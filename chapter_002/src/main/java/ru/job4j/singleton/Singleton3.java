package ru.job4j.singleton;

public class Singleton3 {
    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return Holder.INSTANCE;
    }


    private static final class Holder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
}
