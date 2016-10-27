package com.epam.adk.task2.text_processing.parse;

import com.epam.adk.task2.text_processing.entity.Composite;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.exception.ParsingException;

/**
 * Interface Parser created on 26.10.2016.
 *
 * @author Kaikenov Adilkhan.
 */
public interface Parser {

    Text parse(String source) throws ParsingException;

    <T extends Composite> T parse(String source, Class<T> compositeClass) throws ParsingException;


}
