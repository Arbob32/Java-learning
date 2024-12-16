package com.ru.vsgutu.chapter12;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class TrainTunnelTest {

    @Test
    void testSingleTrain() throws InterruptedException {
        TrainTunnel tunnel = new TrainTunnel(1);
        Train train = new Train(1, tunnel, 100);
        train.start();
        train.join();
        assertTrue(tunnel.enterTunnel1(2, 100));
        tunnel.exitTunnel1(2);
    }

    @Test
    void testConcurrency() throws InterruptedException {
        TrainTunnel tunnel = new TrainTunnel(3);
        ExecutorService executor = Executors.newFixedThreadPool(6);
        for (int i = 1; i <= 10; i++) {
            Train train = new Train(i, tunnel, 100);
            executor.submit(train);
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }
}
