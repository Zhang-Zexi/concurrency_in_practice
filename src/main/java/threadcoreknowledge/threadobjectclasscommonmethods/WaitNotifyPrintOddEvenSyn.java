package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName WaitNotifyPrintOddEvenSyn
 * @Description 两个线程交替打印0~100奇偶数，用synchronized关键字实现
 * @Author zhangzx
 * @Date 2019/11/21 17:20
 * Version 1.0
 **/
public class WaitNotifyPrintOddEvenSyn {

    private static int count;

    private static final Object lock = new Object();

    //新建2个线程
    //1个只处理偶数，2个只处理奇数(用位运算)
    //用synchronized来通信
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1)  == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count ++);
//                            count ++;
                        }
                    }
                }
            }
        }, "偶数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1)  == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count ++);
//                            count ++;
                        }
                    }
                }
            }
        }, "奇数").start();
    }
}
