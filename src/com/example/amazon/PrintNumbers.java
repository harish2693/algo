package com.example.amazon;

public class PrintNumbers {

    private volatile boolean isOdd;

    public synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(number);
        isOdd = false;
        notify();
    }

    public synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(number);
            isOdd = true;
            notify();
        }
    }
}
