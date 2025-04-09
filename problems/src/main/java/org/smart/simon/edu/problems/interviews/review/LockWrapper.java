package org.smart.simon.edu.problems.interviews.review;

// Review:
//public class LockWrapper {
//    private Lock lock;
//
//    public wait() {
//        this.lock.wait()
//    }


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * Обертка над Lock для упрощения интерфейса
 */
public class LockWrapper {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void await() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

}
