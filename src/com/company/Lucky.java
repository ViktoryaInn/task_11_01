package com.company;

public class Lucky {
    private static SomeObject so = new SomeObject();

    static class LuckyThread extends Thread {
        @Override
        public void run() {
            while (so.getX() < 999999) {
                synchronized (so) {
                    so.incrementX();
                    if ((so.getX() % 10) + (so.getX() / 10) % 10 + (so.getX() / 100) % 10 == (so.getX() / 1000)
                            % 10 + (so.getX() / 10000) % 10 + (so.getX() / 100000) % 10) {
                        System.out.println(this.getName() + ' ' + so.getX());
                        so.incrementCount();
                    }
                }
            }
        }
    }

    public static int getCont() {
        return so.getCount();
    }
}
