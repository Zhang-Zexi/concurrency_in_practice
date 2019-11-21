package threadcoreknowledge.sixstates;

/**
 * @ClassName BlockedWaitingTimedWaiting
 * @Description Blocked、Waiting、TimedWaiting
 * @Author zhangzx
 * @Date 2019/11/21 14:54
 * Version 1.0
 **/
public class BlockedWaitingTimedWaiting implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread.sleep(10);
        // 打印出Timed_Waiting状态，因为正在执行Thread.sleep(1000);
        System.out.println(thread1.getState());
        // 打印出Blocked状态，因为thread2想拿到锁，拿不到
        System.out.println(thread2.getState());
        Thread.sleep(1300);
        System.out.println(thread1.getState());
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
