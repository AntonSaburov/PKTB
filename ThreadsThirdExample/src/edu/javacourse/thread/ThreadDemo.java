package edu.javacourse.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by antonsaburov on 23.06.16.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);

        List<Future<?>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Example ex = new Example("name_" + i);
            Future<?> submit = es.submit(ex);
            tasks.add(submit);
        }
        for(Future<?> f : tasks) {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("DONE and DONE");
        es.shutdown();
    }
}

class Example implements Runnable
{
    private String name;

    public Example(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Process is started:" + name);
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
        }
        System.out.println("Process is finished:" + name + (new Date()));
    }
}
