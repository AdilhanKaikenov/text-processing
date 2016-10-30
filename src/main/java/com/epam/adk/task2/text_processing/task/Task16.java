package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.Sentence;
import com.epam.adk.task2.text_processing.entity.SentenceComponent;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.Word;
import com.epam.adk.task2.text_processing.exception.ParsingException;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.parse.RegexTextParser;
import com.epam.adk.task2.text_processing.parse.TextParser;
import com.epam.adk.task2.text_processing.util.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

/**
 * 16.В некотором предложении текста слова заданной длины заменить указанной подстрокой,
 * длина которой может не совпадать с длиной слова.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task16 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task16.class);

    private int length;
    private String someSubString;

    public Task16(int length, String someSubString) {
        this.length = length;
        this.someSubString = someSubString;
    }

    @Override
    public void run(Text text) {

        log.info("Task #16");

        Text textClone = text.clone();
        Iterator<Sentence> iterator = textClone.sentenceItr();

        TextParser parser;
        Sentence parsedSubstring = null;
        try {
            parser = new RegexTextParser();
            parsedSubstring = parser.parseTo(Sentence.class, someSubString);
        } catch (ParsingException | PropertyPathException e) {
            log.error("Error in Task16 class run() method: {}", e);
        }

        List<SentenceComponent> substringComponents = parsedSubstring.getComponents();

        while (iterator.hasNext()){
            Sentence sentence = iterator.next();
            List<Word> words = sentence.getWords();
            List<SentenceComponent> sentenceComponents = sentence.getComponents();

            for (Word word : words){
                if (word.length() == this.length){
                    int index = sentenceComponents.indexOf(word);
                    sentenceComponents.set(index, substringComponents.get(0));
                }
            }
        }
        Printer.print(textClone);
    }
}
