import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {

    ReentrantLock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        for (int i = 0; i < 10; i++)
            System.out.println(i);
        lock.unlock();
    }

    void m2() {
        lock.lock();
        try {
            System.out.println("m2 Start!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();
        new Thread(() -> reentrantLock1.m1()).start();
        new Thread(() -> reentrantLock1.m2()).start();
    }
}
