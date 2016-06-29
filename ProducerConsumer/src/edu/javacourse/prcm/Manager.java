package edu.javacourse.prcm;

/**
 * Created by antonsaburov on 27.06.16.
 */
public class Manager
{
    private int value;
    private boolean isPut = false;

    public synchronized void setValue(int value) {
        while(isPut) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("PUT:" + value);
        this.value = value;
        isPut = true;
        notifyAll();
    }

    public synchronized int getValue() {
        while(!isPut) {
            try {
                wait();         // Thread Consumer
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("GET:" + value);
        isPut = false;
        notifyAll();
        return value;
    }

}
