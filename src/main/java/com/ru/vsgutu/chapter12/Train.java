package com.ru.vsgutu.chapter12;

class Train extends Thread {
    private final int id;
    private final TrainTunnel tunnel;
    private final long maxWaitTime;

    public Train(int id, TrainTunnel tunnel, long maxWaitTime) {
        this.id = id;
        this.tunnel = tunnel;
        this.maxWaitTime = maxWaitTime;
    }

    @Override
    public void run() {
        try {
            if (tunnel.enterTunnel1(id, maxWaitTime)) {
                Thread.sleep(1000);
                tunnel.exitTunnel1(id);
            } else if (tunnel.enterTunnel2(id, maxWaitTime)) {
                Thread.sleep(1000);
                tunnel.exitTunnel2(id);
            } else {
                System.out.println("Поезд " + id + " не может попасть в тунель");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
