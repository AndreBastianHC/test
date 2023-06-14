package threads;

import app.App;

public class ThreadSynchronized extends Thread{
    private long sleep;
    private int sum;

    public ThreadSynchronized(final long sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        App.i++;
        System.out.println(App.i);
    }

    public int getSum() {
        return this.sum;
    }
}
