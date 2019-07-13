package ru.job4j.priorityqueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        var it = tasks.listIterator();
        while (it.hasNext()) {
            if (it.next().getPriority() > task.getPriority()) {
                it.previous();
                break;
            }
        }
        it.add(task);
    }

    public Task take() {
        return this.tasks.poll();
    }

}

