package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable w) {
                if (w instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                } else if (w instanceof Exception) {
                    System.out.println("Надо обработать");
                } else if (w != null) {
                    System.out.println("Поживем - увидим");
                }
            }
        });
    }



    public static void main(String[] args) {
    }
}
