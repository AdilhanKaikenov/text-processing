package com.epam.adk.task2.text_processing.parse;

import com.epam.adk.task2.text_processing.entity.*;
import com.epam.adk.task2.text_processing.exception.ParsingException;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.util.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegexTextParser class created on 26.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see Parser
 */
public final class RegexTextParser implements Parser {

    private static final Logger log = LoggerFactory.getLogger(RegexTextParser.class);

    private static Properties properties;
    private static Map<Class<? extends Composite>, String> regularExpressions = new HashMap<>();
    private static Map<Class<? extends Composite>, Class<? extends Component>> componentClasses = new HashMap<>();

    public RegexTextParser() throws PropertyPathException {
        PropertyLoader regexLoader = new PropertyLoader("parser-regex.properties");
        properties = regexLoader.getProperties();
        regularExpressions = loadRegularExpressions();
        componentClasses = loadComponentClasses();
    }

    private static Map<Class<? extends Composite>, String> loadRegularExpressions() {
        regularExpressions.put(Text.class, properties.getProperty("textToParagraphRegex"));
        regularExpressions.put(Paragraph.class, properties.getProperty("paragraphToSentenceRegex"));
        regularExpressions.put(Sentence.class, properties.getProperty("sentenceToSentenceComponentRegex"));
        regularExpressions.put(Word.class, properties.getProperty("wordToSymbolRegex"));
        regularExpressions.put(PMark.class, properties.getProperty("pMarkToSymbolRegex"));
        return regularExpressions;
    }

    private static Map<Class<? extends Composite>, Class<? extends Component>> loadComponentClasses() {
        componentClasses.put(Text.class, Paragraph.class);
        componentClasses.put(Paragraph.class, Sentence.class);
        componentClasses.put(Sentence.class, SentenceComponent.class);
        componentClasses.put(Word.class, Symbol.class);
        componentClasses.put(PMark.class, Symbol.class);
        return componentClasses;
    }

    @Override
    public Text parse(String source) throws ParsingException {
        return parse(source, Text.class);
    }

    @Override
    public <T extends Composite> T parse(String source, Class<T> compositeClass) throws ParsingException {
        T composite;
        Class componentClass;
        try {
            composite = compositeClass.newInstance();
            String regex = regularExpressions.get(composite.getClass());
            componentClass = componentClasses.get(compositeClass);

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(source);
            while (matcher.find()) {
                String matchedString = matcher.group();
                if (componentClass == SentenceComponent.class) {
                    Component component = identifySentenceComponent(matchedString);
                    composite.add(component);
                } else if (componentClass == Symbol.class) {
                    Symbol symbol = new Symbol(matchedString.charAt(0));
                    composite.add(symbol);
                } else {
                    Composite component = parse(matchedString, componentClass);
                    composite.add(component);
                }
            }
            return composite;
        } catch (Exception e) {
            log.error("Error in parse method {}", e);
            throw new ParsingException(MessageFormat.format("Error in parse method {0}.", e));
        }
    }

    private Component identifySentenceComponent(String matchedString) throws ParsingException {
        Component component = null;

        if (matchedString.matches(properties.getProperty("word"))) {
            component = parse(matchedString, Word.class);
        } else if (matchedString.matches(properties.getProperty("pMark"))) {
            component = parse(matchedString, PMark.class);
        }
        return component;
    }
}
