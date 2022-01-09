package com.perenok.study.thread;

public class Main {
    public static void main(String[] args) {
        final SimpleLock simpleLock = new SimpleLock(); // shared resource

        for (int i = 0; i < 20; i++) {
            new Thread(new SimpleRunnable(simpleLock)).start();
        }
    }
}
