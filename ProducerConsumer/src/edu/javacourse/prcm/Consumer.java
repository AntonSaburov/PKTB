package edu.javacourse.prcm;

/**
 * Created by antonsaburov on 27.06.16.
 */
public class Consumer implements Runnable
{
    private Manager manager;

    public Consumer(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            manager.getValue();
        }
    }
}
