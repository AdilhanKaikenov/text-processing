package com.epam.adk.task2.text_processing.io;

import com.epam.adk.task2.text_processing.exception.ReadingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.MessageFormat;

/**
 * TextReader class created on 23.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Reader
 */
public final class TextReader implements Reader {

    private static final Logger log = LoggerFactory.getLogger(TextReader.class);

    @Override
    public String read(String fileName, String charsetName) throws ReadingException {

        log.debug("Started to read file '{}', encoding - {}", fileName, charsetName);

        File file = new File(fileName);

        if (!file.exists()){
            log.error("File - '{}' was not found.", file);
            throw new ReadingException(MessageFormat.format("File - {0} was not found.", file));
        }

        StringBuilder sb = new StringBuilder();
        String line;

        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), charsetName))){
            while ((line = in.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error("Error reading file. {}", e);
            throw new ReadingException(MessageFormat.format("Error reading file. {0}.", file));
        }
        return sb.toString();
    }
}
