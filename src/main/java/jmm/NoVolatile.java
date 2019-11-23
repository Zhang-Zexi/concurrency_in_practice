package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName NoVolatile
 * @Description 不适用于volatile的场景
 * @Author zhangzx
 * @Date 2019/11/23 10:43
 * Version 1.0
 **/
public class NoVolatile implements Runnable {

    volatile int a;
    AtomicInteger readA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new NoVolatile();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread1.join();
        System.out.println(((NoVolatile) r).a);
        System.out.println(((NoVolatile) r).readA.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i ++) {
            a ++;
            readA.incrementAndGet();
        }
    }
}
