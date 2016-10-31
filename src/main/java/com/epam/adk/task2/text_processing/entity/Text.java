package com.epam.adk.task2.text_processing.entity;

/**
 * Text class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see TextComposite
 */
public class Text extends AbstractTextComposite<Paragraph> {
    
    @Override
    public Text clone() {
        Text text = new Text();
        for (Paragraph paragraph : this.getComponents()) {
            text.add(paragraph.clone());
        }
        return text;
    }
}


