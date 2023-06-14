package app;

import threads.ThreadCountdownLatch;
import threads.ThreadSimple;
import threads.ThreadSynchronized;

import java.util.concurrent.CountDownLatch;

public class App {

    public static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        threadSynchronized();
    }


    public static void threadJoin() throws InterruptedException {
        ThreadSimple threadSimple1 = new ThreadSimple(1000);
        ThreadSimple threadSimple2 = new ThreadSimple(500);

        threadSimple1.start();
        threadSimple2.start();

        threadSimple1.join();
        threadSimple2.join();

        System.out.println("End");

    }
    public static void threadCountdownLatch() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Thread thread = new Thread(new ThreadCountdownLatch(latch,1000));
        thread.start();

        thread = new Thread(new ThreadCountdownLatch(latch,2000));
        thread.start();

        thread = new Thread(new ThreadCountdownLatch(latch,500));
        thread.start();

        System.out.println("Before await");
        latch.await();
        System.out.println("After await");

    }

    public static void threadSynchronized(){
        new ThreadSynchronized(100).start();
        new ThreadSynchronized(100).start();
    }
}
