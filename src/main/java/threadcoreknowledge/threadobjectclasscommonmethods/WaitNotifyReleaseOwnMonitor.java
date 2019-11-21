package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName WaitNotifyReleaseOwnMonitor
 * @Description 证明wait只释放当前的那把锁
 * @Author zhangzx
 * @Date 2019/11/21 16:36
 * Version 1.0
 **/
public class WaitNotifyReleaseOwnMonitor {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("ThreadA got resourceA lock.");
                    synchronized (resourceB) {
                        System.out.println("ThreadA got resourceB lock.");
                        try {
                            resourceA.wait();
                            System.out.println("ThreadA got releases resouceA lock.");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("ThreadB got resouceA lock.");
                    System.out.println("ThreadB tries to  resouceB lock.");
                    synchronized (resourceB) {
                        System.out.println("ThreadB got resouceB lock.");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
