package edu.javacourse.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 23.06.16.
 */
public class ThreadDemo
{
    public static void main(String[] args) {
        firstDemo();
        secondDemo();
    }

    private static void firstDemo() {
        List<Example2> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            list.add(new Example2());
        }
        System.out.println(System.currentTimeMillis());
        for(Example2 e : list) {
            Thread thread = new Thread(e);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e1) {
            }
        }
        System.out.println(System.currentTimeMillis());
    }

    private static void secondDemo() {
        Example3 ex = new Example3();
        new Thread(ex).start();
        try {
            System.out.println("WAITING ...");
            Thread.sleep(5000);
        } catch(Exception e) {
        }
        ex.stopProcess();
        System.out.println("Process is stopped");
    }
}


class Example extends Thread
{
    public void run() {
        System.out.println("Process is started");
        try {
            Thread.sleep(2000);
        } catch(Exception ex) {
        }
        System.out.println("Process is finished");
    }
}

class Example2 implements Runnable
{
    @Override
    public void run() {
        System.out.println("Process is started");
        try {
            Thread.sleep(2000);
        } catch(Exception ex) {
        }
        System.out.println("Process is finished");
    }
}

class Example3 implements Runnable
{
    private volatile boolean isRunning = true;

    public void stopProcess() {
        isRunning = false;
    }

    @Override
    public void run() {
        int counter = 0;
        while(isRunning) {
            System.out.println("Process is started");
            try {
                Thread.sleep(200);
            } catch(Exception ex) {
            }
            if(counter > 3) {
                throw new RuntimeException("SUPER EXCEPTION");
            }
            System.out.println("Process is finished");
            counter++;
        }
    }
}