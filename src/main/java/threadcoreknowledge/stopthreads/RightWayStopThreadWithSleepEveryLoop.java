package threadcoreknowledge.stopthreads;

/**
 * @ClassName RightWayStopThreadWithSleepEveryLoop
 * @Description 如果执行过程中，每次循环都会调用sleep或wait等方法, 那么我们不需要每次迭代都检查是否中断
 *  * @Author zhangzx
 * @Date 2019/11/20 20:04
 * Version 1.0
 **/
public class RightWayStopThreadWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(5000);
        thread.interrupt();
    }
}
