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

    /**
     * The method for parsing source string.
     *
     * @param source target source string to parse.
     * @return Text instance.
     * @throws ParsingException
     */
    Text parse(String source) throws ParsingException;

    /**
     * The method for parsing source string.
     *
     * @param source target source string to parse.
     * @param compositeClass Composite type class which we need to parse.
     * @param <T> type parameterization.
     * @return <T extends Composite> T instance.
     * @throws ParsingException
     */
    <T extends Composite> T parse(String source, Class<T> compositeClass) throws ParsingException;


}
