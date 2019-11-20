package threadcoreknowledge.stopthreads;

/**
 * @ClassName RightWayStopThreadWithSleep
 * @Description 带有sleep中断线程的写法
 * @Author zhangzx
 * @Date 2019/11/20 19:54
 * Version 1.0
 **/
public class RightWayStopThreadWithSleep {

    // 等待期间中断
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(500);
        thread.interrupt();
    }
}
