import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private static Integer i = 0;
    private static Integer i2 = 0;
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private static Object lock = new Object();

    private static void increment() {
        lock1.lock();
        i++;
        lock1.unlock();
    }

    private static void decrement() {
        lock2.lock();
        i2--;
        lock2.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                increment();
            }
        }, "Increment1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                decrement();
            }
        }, "Decrement1");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Value of Integer: " + i);
        System.out.println("Final Value of Integer: " + i2);
    }
}
