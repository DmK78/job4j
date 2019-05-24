package ru.job4j.professions;

import java.util.Date;

public class Doctor extends Profession {
    public Doctor(String name, String surname, String education, Date birthday) {
        super(name, surname, education, birthday);
    }

    public Heal heal(Pacient pacient) {
        return pacient.getDiagnose().getHeal();
    }
}
