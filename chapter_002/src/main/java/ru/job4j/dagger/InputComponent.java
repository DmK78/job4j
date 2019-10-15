package ru.job4j.dagger;

import dagger.Component;

@Component(modules = {InputModule.class,
OutputModule.class})

public interface InputComponent {
    Calc instance();

}
