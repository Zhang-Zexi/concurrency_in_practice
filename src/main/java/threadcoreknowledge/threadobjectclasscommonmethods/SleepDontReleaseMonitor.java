package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName SleepDontReleaseMonitor
 * @Description 展示线程sleep的时候，不释放synchronized的monitor，等sleep时间到了以后，正常结束才释放锁
 * @Author zhangzx
 * @Date 2019/11/21 18:41
 * Version 1.0
 **/
public class SleepDontReleaseMonitor implements Runnable{

    public static void main(String[] args) {
        SleepDontReleaseMonitor sleepDontReleaseMonitor = new SleepDontReleaseMonitor();
        new Thread(sleepDontReleaseMonitor).start();
        new Thread(sleepDontReleaseMonitor).start();
    }
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println("线程" + Thread.currentThread().getName() + "获取到monitor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "退出了同步代码块");
    }
}
