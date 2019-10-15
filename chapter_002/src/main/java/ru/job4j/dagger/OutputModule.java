package ru.job4j.dagger;

import dagger.Provides;
import dagger.Module;


@Module
public class OutputModule {

        @Provides
        public static Out provideOutput(){
            return new Output();
        }

    }
