package ru.job4j.professions;

import java.util.Date;

public class Engineer extends Profession {
    public Engineer(String name, String surname, String education, Date birthday) {
        super(name, surname, education, birthday);
    }

    public void writeReport() {
    }

    public Job makeAproject(Task task) {
        Job job = task.getJob();
        return job;
    }
}
