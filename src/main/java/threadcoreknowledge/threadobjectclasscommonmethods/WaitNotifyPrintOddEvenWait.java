package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName WaitNotifyPrintOddEvenSyn
 * @Description 两个线程交替打印0~100奇偶数，用wait/notify关键字实现
 * @Author zhangzx
 * @Date 2019/11/21 17:20
 * Version 1.0
 **/
public class WaitNotifyPrintOddEvenWait {

    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new TurningRunner(), "偶数").start();
//        Thread.sleep(100);
        new Thread(new TurningRunner(),"奇数").start();
    }

    // 1.拿到锁，我们就打印
    // 2.打印完，唤醒其他线程就休眠
    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count ++);
                    lock.notify();
                    if ( count <= 100) {
                        try {
                            // 如果任务还没有结束，让出当前锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
