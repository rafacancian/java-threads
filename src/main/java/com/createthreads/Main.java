package com.createthreads;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        // 1 - Creating a custom Thread
        CustomThread customThread = new CustomThread();
        customThread.start();

        // 2 - Creating a runnable Thread
        Runnable myRunnable = () -> {
            for (int i = 1; i <= 8; i++) {
                System.out.print(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        // 3 - Using the current thread
        // References the currently running thread.
        // Does not create a new thread; instead, it provides access to the thread that is already executing the code.
        // Useful for obtaining information about the current thread, like its name or ID. */
        for (int i = 1; i <= 3; i++) {
            System.out.print(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());
        System.out.println(currentThread);
        printThreadState(currentThread);

        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(currentThread);
    }

    public static void printThreadState(Thread thread) {
        System.out.println("----------------------");
        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
        System.out.println("Thread State: " + thread.getState());
        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread Is Alive: " + thread.isAlive());
        System.out.println("----------------------");
    }
}
