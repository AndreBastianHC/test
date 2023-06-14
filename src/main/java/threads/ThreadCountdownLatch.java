package threads;

import java.util.concurrent.CountDownLatch;

public class ThreadCountdownLatch implements Runnable{

    private final CountDownLatch latch;
    private final int delayInMs;

    public ThreadCountdownLatch(CountDownLatch latch, int delayInMs) {
        this.delayInMs = delayInMs;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delayInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        latch.countDown();
        System.out.println(Thread.currentThread().getName() + " finished");
        System.out.println(latch.getCount());
    }
}
