package com.example.amazon;

public class Print {

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        Thread t1 = new Thread(new TaskRunner(printNumbers, 10, false));
        Thread t2 = new Thread(new TaskRunner(printNumbers, 10, true));
        t1.start();
        t2.start();
    }
}
