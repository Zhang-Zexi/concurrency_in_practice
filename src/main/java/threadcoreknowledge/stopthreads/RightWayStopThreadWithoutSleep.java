package threadcoreknowledge.stopthreads;

/**
 * @ClassName RightWayStopThreadWithoutSleep
 * @Description run方法内没有sleep/wait方法时停止线程
 * @Author zhangzx
 * @Date 2019/11/20 19:41
 * Version 1.0
 **/
public class RightWayStopThreadWithoutSleep implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    @Override
    public void run() {
        int num = 0;
        // 必须让它自己想要停止判断
        while (!Thread.currentThread().isInterrupted() && num  <= Integer.MAX_VALUE / 2) {
            if (num % 1000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num ++;
        }
        System.out.println("任务运行结束了");
    }
}
