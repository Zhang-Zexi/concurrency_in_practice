package jmm;

import java.awt.*;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName OutOfOrderExecution
 * @Description 演示重排序的现象
 * 知道某个条件才停止
 * @Author zhangzx
 * @Date 2019/11/22 18:07
 * Version 1.0
 **/
public class OutOfOrderExecution {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        for( ; ; ) { // 循环直到输出某个值
            i ++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            CountDownLatch latch = new CountDownLatch(1);

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });
            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });
//        two.start();
//        one.start();
            one.start();
            two.start();
            latch.countDown();
            one.join();
            two.join();

            String result = "第" + i + "次 (" + x + "," + y + ")";
            if (x == 1 && y == 1) {
                System.out.println("x = " + x + ", y = " + y);
                break;
            } else {
                System.out.println("x = " + x + ", y = " + y);
            }
        }
    }
}
