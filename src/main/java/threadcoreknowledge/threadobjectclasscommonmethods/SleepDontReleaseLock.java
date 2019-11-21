package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName SleepDontReleaseLock
 * @Description sleep不释放lock
 * @Author zhangzx
 * @Date 2019/11/21 18:50
 * Version 1.0
 **/
public class SleepDontReleaseLock implements Runnable {

    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        new Thread(new SleepDontReleaseLock()).start();
        new Thread(new SleepDontReleaseLock()).start();
    }
}
