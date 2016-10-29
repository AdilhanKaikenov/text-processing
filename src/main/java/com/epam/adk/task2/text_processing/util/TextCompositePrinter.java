package com.epam.adk.task2.text_processing.util;

import com.epam.adk.task2.text_processing.entity.TextComposite;
import com.epam.adk.task2.text_processing.entity.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * TextCompositePrinter class Created on 08.11.2015.
 *
 * @author Kaikenov Adilkhan
 */
public class TextCompositePrinter {

    private static final Logger log = LoggerFactory.getLogger(TextCompositePrinter.class);

    /**
     * The method for displaying list of composite as a numbered.
     *
     * @param list     list of composite.
     * @param numbered boolean true for numbering, false for not.
     * @param <E>      type parameterization.
     */
    public static <E extends TextComposite> void print(List<E> list, boolean numbered) {
        if (!list.isEmpty() && numbered) {
            int i = 1;
            for (TextComposite composite : list) {
                log.info("{}){}", i++, composite.toString().trim());
            }
            System.out.println();
        } else {
            print(list);
        }
    }

    /**
     * The method for displaying list of composite.
     *
     * @param list list of composite.
     * @param <E>  type parameterization.
     */
    public static <E extends TextComposite> void print(List<E> list) {
        if (!list.isEmpty()) {
            for (TextComposite composite : list) {
                log.info(composite.toString().trim());
            }
            System.out.println();
        }
    }

    /**
     * The method for displaying text.
     *
     * @param text text to be displayed to the console.
     */
    public static void print(Text text) {
        System.out.println(text);
    }
}
