package com.example.amazon;

public class TaskRunner implements Runnable {

    private PrintNumbers printNumbers;
    private int max;
    private boolean isEvenNumber;

    public TaskRunner(PrintNumbers printNumbers, int max, boolean isEvenNumber) {
        this.printNumbers = printNumbers;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                printNumbers.printEven(number);
            } else {
                printNumbers.printOdd(number);
            }
            number += 2;
        }
    }
}
