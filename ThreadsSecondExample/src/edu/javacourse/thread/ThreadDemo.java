package edu.javacourse.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by antonsaburov on 23.06.16.
 */
public class ThreadDemo
{
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);

        Example ex1 = new Example("name1");
        Future<?> f = es.submit(ex1);
        boolean done1 = f.isDone();
        System.out.println("IsDone:" + done1);

        try {
            //Thread.sleep(5000);
            //1.stopProcess();
            Object o = f.get();
            System.out.println("Result:" + o);
            boolean done2 = f.isDone();
            System.out.println("IsDone:" + done2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        es.shutdown();
    }
}

class Example implements Runnable
{
    private volatile boolean isRunning = true;
    private String name;

    public void stopProcess() {
        isRunning = false;
    }

    public Example(String name) {
        this.name = name;
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
                return;
//                throw new RuntimeException("SUPER EXCEPTION");
            }
            System.out.println("Process is finished");
            counter++;
        }
    }
}
