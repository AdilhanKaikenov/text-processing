package com.epam.adk.task2.text_processing.main;

import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.io.TextReader;
import com.epam.adk.task2.text_processing.parse.RegexTextParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextProcessingAppTest {

    @Test
    public void mainTest() throws Exception {

        TextReader reader = new TextReader();
        String expected = reader.read("text.txt", "utf-8");

        RegexTextParser textParser = new RegexTextParser();
        Text parsedText = textParser.parse(expected);
        String actual = parsedText.toSourceString();

        assertEquals(expected, actual);
    }

}