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
        ListIterator<Task> it = tasks.listIterator();
        while (it.hasNext()) {
            Task curTask = it.next();
            if (curTask.getPriority() > task.getPriority()) {
                it.set(it.previous());
                break;
            }
        }
        it.add(task);
    }

    public Task take() {
        return this.tasks.poll();
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("3", 3));
        queue.put(new Task("2", 2));
        queue.put(new Task("1", 1));


    }
}

