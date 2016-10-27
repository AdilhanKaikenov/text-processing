package com.epam.adk.task2.text_processing.util;

import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.task.Task;

import java.util.List;

/**
 * TaskExecutor class created on 27.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public final class TaskExecutor {

    /**
     * The method for performing tasks.
     *
     * @param tasks List of tasks.
     * @param text target text.
     */
    public static void performTask(List<Task> tasks, Text text) {
        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                task.run(text);
            }
        }
    }

    /**
     * The method to perform the task.
     *
     * @param task task.
     * @param text target text.
     */
    public static void performTask(Task task, Text text){
        task.run(text);
    }

}
