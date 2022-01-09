package com.perenok.study.thread;

public class SimpleRunnable implements Runnable {

    private final SimpleLock simpleLock;

    public SimpleRunnable(SimpleLock simpleLock) {
        this.simpleLock = simpleLock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - " + simpleLock.tryLock());
    }
}