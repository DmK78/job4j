package ru.job4j.professions;

public class Engineer extends Profession {
    public void writeReport() {
    }

    public Job makeAproject(Task task) {
        Job job = task.getJob();
        return job;
    }
}
