package com.epam.adk.task2.text_processing.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created on 23.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Reader
 */
public class TextReader implements Reader<String> {

    private static final Logger log = LoggerFactory.getLogger(TextReader.class);

    @Override
    public String read(String fileName, String charsetName) {

        log.debug("Started to read file '{}', encoding - {}", fileName, charsetName);

        Path path = Paths.get(fileName);

        if (!Files.exists(path)){
            log.error("File - '{}' was not found.", path);
            throw new RuntimeException();
        }

        StringBuilder sb = new StringBuilder();
        String line;

        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(path.toFile()), charsetName))){
            while ((line = in.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error("Error reading file. {}", e);
            throw new RuntimeException();
        }
        return sb.toString();
    }
}
