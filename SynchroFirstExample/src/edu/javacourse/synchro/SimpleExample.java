package edu.javacourse.synchro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 27.06.16.
 */
public class SimpleExample
{
    private Long counter = 0L;
    private String lockStr = "";

    public void increaseCounter() {
        synchronized(lockStr) {
            counter++;
        }
    }

    public synchronized Long getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {

        SimpleExample se = new SimpleExample();

        for(int i=0; i<100; i++) {
            CounterChanger cc = new CounterChanger(se);
            new Thread(cc).start();
        }
        Thread.sleep(1000);
        System.out.println(se.counter);
    }
}

class CounterChanger implements Runnable
{
    private SimpleExample example;

    public CounterChanger(SimpleExample example) {
        this.example = example;
    }

    @Override
    public void run() {
        for(int i=0; i<50; i++) {
            example.increaseCounter();
        }
    }
}
