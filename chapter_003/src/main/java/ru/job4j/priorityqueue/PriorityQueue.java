package ru.job4j.priorityqueue;

import java.util.LinkedList;

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
        boolean taskAdded = false;
        if (tasks.size() != 0) {
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() <= tasks.get(i).getPriority()) {
                    tasks.add(i, task);
                    taskAdded = true;
                    break;
                }
            }
        } else {
            tasks.add(task);
            taskAdded = true;
        }
        if (!taskAdded) {
            tasks.add(tasks.size() - 1, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}