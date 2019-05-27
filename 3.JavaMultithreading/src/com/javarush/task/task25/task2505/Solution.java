package com.javarush.task.task25.task2505;

import java.lang.reflect.Field;
import java.util.logging.Logger;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {

        }
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            public void uncaughtException(Thread t, Throwable throwable) {
                try {
                    Thread.sleep(500);
                    System.out.println(String.format("%s, %s, %s", secretKey, t.getName(), throwable.getMessage()));
                    Logger logger = Logger.getLogger(throwable.toString());
                } catch (InterruptedException e) {

                }
            }

        }
    }




}

