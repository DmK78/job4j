package ru.job4j.professions;

public class Doctor extends Profession {
    public Heal heal(Pacient pacient) {
        return pacient.getDiagnose().getHeal();
    }
}
