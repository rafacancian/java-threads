package com.interruptthread;


class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("OddThread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("OddThread interrupted");
                break;
            }
        }
    }
}

class EvenThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println("EvenThread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("EvenThread interrupted");
                break;
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        OddThread oddThread = new OddThread();
        Thread evenThread = new Thread(new EvenThread());
        //EvenThread evenThread = new EvenThread();

        oddThread.start();
        evenThread.start();
        //evenThread.run();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        oddThread.interrupt();
    }
}
