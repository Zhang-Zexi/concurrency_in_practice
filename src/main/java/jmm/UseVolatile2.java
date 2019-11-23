package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName UseVolatile1
 * @Description volatile不适用的情况2
 * @Author zhangzx
 * @Date 2019/11/23 10:52
 * Version 1.0
 **/
public class UseVolatile2 implements Runnable {

    volatile boolean done = false;
    AtomicInteger readA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new UseVolatile2();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread1.join();
        System.out.println(((UseVolatile2) r).done);
        System.out.println(((UseVolatile2) r).readA.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            flipDone();
            readA.incrementAndGet();
        }
    }

    private void flipDone() {
        done = !done;
    }
}
