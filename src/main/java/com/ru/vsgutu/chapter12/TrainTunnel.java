package com.ru.vsgutu.chapter12;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TrainTunnel {
    private final Semaphore semaphore1;
    private final Semaphore semaphore2;
    private final ReentrantLock lock;

    public TrainTunnel(int maxTrains) {
        semaphore1 = new Semaphore(maxTrains);
        semaphore2 = new Semaphore(maxTrains);
        lock = new ReentrantLock();
    }

    public boolean enterTunnel1(int trainId, long maxWaitTime) throws InterruptedException {
        if (semaphore1.tryAcquire(maxWaitTime, TimeUnit.MILLISECONDS)) {
            System.out.println("Поезд " + trainId + " попал в тунель 1");
            return true;
        } else {
            System.out.println(
                    "Поезд "
                            + trainId
                            + " ждет слишком долго тунель 1, перенаправление в тунель 2");
            return false;
        }
    }

    public boolean enterTunnel2(int trainId, long maxWaitTime) throws InterruptedException {
        lock.lock();
        try {
            if (semaphore2.tryAcquire(maxWaitTime, TimeUnit.MILLISECONDS)) {
                System.out.println("Поезд " + trainId + " попал в тунель 2");
                return true;
            } else {
                System.out.println(
                        "Поезд "
                                + trainId
                                + " ждет слишком долго тунель 2, перенаправление в тунель 1");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void exitTunnel1(int trainId) {
        semaphore1.release();
        System.out.println("Поезд " + trainId + " покинул тунель 1");
    }

    public void exitTunnel2(int trainId) {
        semaphore2.release();
        System.out.println("Поезд " + trainId + " покинул тунель 2");
    }
}
