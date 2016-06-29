package edu.javacourse.prcm;

/**
 * Created by antonsaburov on 27.06.16.
 */
public class Main
{
    public static void main(String[] args) {
        Manager m = new Manager();

        Producer p = new Producer(m);
        Consumer c = new Consumer(m);

        new Thread(p).start();
        new Thread(c).start();
    }
}
