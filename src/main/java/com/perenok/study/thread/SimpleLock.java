package com.perenok.study.thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleLock {

    private AtomicBoolean locked = new AtomicBoolean();

    public boolean tryLock() {
        if (!locked.get()) {
            for (int i = 0; i < 100000; i++) { }
        }
        return locked.compareAndSet(false, true);
    }
}
