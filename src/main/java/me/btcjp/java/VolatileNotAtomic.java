package me.btcjp.java;

public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        Thread substraceThread = new SubtraceThread();
        substraceThread.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic.class) {
                count++;
            }
        }

        while (substraceThread.isAlive()) {}

        System.out.println("last count value: " + count);
    }

    private static class SubtraceThread extends Thread {
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (VolatileNotAtomic.class) {
                    count--;
                }
            }
        }
    }
}
