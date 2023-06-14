package threads;

public class ThreadSimple extends Thread{
    private long sleep;
    private int sum;

    public ThreadSimple(final long sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
            sum += i;
            try {
                Thread.sleep(sleep);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getSum() {
        return this.sum;
    }
}
