package edu.javacourse.synchro;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by antonsaburov on 27.06.16.
 */
public class ListExample
{
    public static void main(String[] args) {
        Queue<String> list = new ConcurrentLinkedQueue<>();
        for(int i=0; i<40; i++) {
            ListThread lt = new ListThread(list);
            Thread t = new Thread(lt);
            t.start();
        }
        System.out.println(list.size());
    }
}


class ListThread implements Runnable
{
    private Queue<String> list;

    public ListThread(Queue<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i=0; i<500; i++) {
            list.add("String" + i);
        }
    }
}