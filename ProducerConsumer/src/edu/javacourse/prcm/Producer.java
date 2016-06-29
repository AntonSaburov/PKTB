package edu.javacourse.prcm;

/**
 * Created by antonsaburov on 27.06.16.
 */
public class Producer implements Runnable
{
    private Manager manager;

    public Producer(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            manager.setValue(i);
        }
    }
}
