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
 * @see TextParser
 */
public final class RegexTextParser implements TextParser {

    private static final Logger log = LoggerFactory.getLogger(RegexTextParser.class);
    private static final String PARSER_REGEX_PROPERTIES = "parser-regex.properties";

    private static Properties properties;
    private static PropertyLoader regexLoader = new PropertyLoader();
    private static Map<Class<? extends Composite>, Pattern> regularExpressions = new HashMap<>();
    private static Map<Class<? extends Composite>, Class<? extends Component>> componentClasses = new HashMap<>();

    public RegexTextParser() throws PropertyPathException {
        properties = regexLoader.getProperties(PARSER_REGEX_PROPERTIES);
        regularExpressions = loadRegularExpressions();
        componentClasses = loadComponentClasses();
    }

    /**
     * The method for initializing the Map<Class<Composite>, String> containing the regular expressions to parseTo the composites.
     *
     * @return map containing the regular expressions to parseTo the composites e.g. Text to Paragraph, Paragraph to Sentence etc.
     */
    private static Map<Class<? extends Composite>, Pattern> loadRegularExpressions() {
        regularExpressions.put(Text.class, Pattern.compile(properties.getProperty("textToParagraphRegex")));
        regularExpressions.put(Paragraph.class, Pattern.compile(properties.getProperty("paragraphToSentenceRegex")));
        regularExpressions.put(Sentence.class, Pattern.compile(properties.getProperty("sentenceToSentenceComponentRegex")));
        regularExpressions.put(Word.class, Pattern.compile(properties.getProperty("wordToSymbolRegex")));
        regularExpressions.put(PMark.class, Pattern.compile(properties.getProperty("pMarkToSymbolRegex")));
        return regularExpressions;
    }

    /**
     * The method for initializing the Map<Class<Composite>, Class<Component>> containing the component classes.
     *
     * @return map containing the component classes of the composite classes.
     */
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
        return parseTo(Text.class, source);
    }

    @Override
    public <T extends Composite> T parseTo(Class<T> compositeClass, String source) throws ParsingException {
        log.debug("Entering parseTo(): parse source string with length = '{}', to '{}'.", source.length(), compositeClass.getSimpleName());
        T composite;
        Class componentClass;
        try {
            composite = compositeClass.newInstance();
            componentClass = componentClasses.get(compositeClass);

            Pattern pattern = regularExpressions.get(composite.getClass());
            Matcher matcher = pattern.matcher(source);
            while (matcher.find()) {
                String matchedString = matcher.group();
                if (componentClass.equals(SentenceComponent.class)) {
                    Component component = identifySentenceComponent(matchedString);
                    composite.add(component);
                } else if (componentClass.equals(Symbol.class)) {
                    Symbol symbol = Symbol.of(matchedString.charAt(0));
                    composite.add(symbol);
                } else {
                    Composite component = parseTo(componentClass, matchedString);
                    composite.add(component);
                }
            }
            return composite;
        } catch (Exception e) {
            log.error("Error in parseTo method {}", e);
            throw new ParsingException(MessageFormat.format("Error in parseTo method {0}.", e));
        }
    }

    /**
     * The method for determining a component of the sentence. Such as words and punctuation.
     *
     * @param matchedString string to define a specific component of the sentence.
     * @return Component type (Word, PMark)
     * @throws ParsingException
     */
    private Component identifySentenceComponent(String matchedString) throws ParsingException {
        Component component = null;

        if (matchedString.matches(properties.getProperty("word"))) {
            component = parseTo(Word.class, matchedString);
        } else if (matchedString.matches(properties.getProperty("pMark"))) {
            component = parseTo(PMark.class, matchedString);
        }
        return component;
    }
}
