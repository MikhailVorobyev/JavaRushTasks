package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            //System.out.println("isInterrupted: " + thread.isInterrupted());
            System.out.println(thread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                thread.interrupt();
            }
        }

    }

    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    public void stop() {
        if (thread.getName().equals("fifth")){
            thread.interrupt();
        }
    }
}
