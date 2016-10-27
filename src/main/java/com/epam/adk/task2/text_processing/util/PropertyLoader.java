package com.epam.adk.task2.text_processing.util;

import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * PropertyLoader class created on 25.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public final class PropertyLoader {

    private static final Logger log = LoggerFactory.getLogger(PropertyLoader.class);

    private String nameProperty;

    public PropertyLoader(String nameProperty) {
        this.nameProperty = nameProperty;
    }

    public Properties getProperties() throws PropertyPathException {
        Properties properties = new Properties();
        try (InputStream in = PropertyLoader.class.getClassLoader().getResourceAsStream(nameProperty)) {
            properties.load(in);
        } catch (IOException e) {
            log.error("Invalid path to property file : {}", nameProperty);
            throw new PropertyPathException(MessageFormat.format("Error reading file. {0}.", nameProperty));
        }
        return properties;
    }
}