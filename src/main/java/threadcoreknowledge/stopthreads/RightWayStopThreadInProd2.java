package threadcoreknowledge.stopthreads;

/**
 * @ClassName RightWayStopThreadInProd2
 * @Description 最佳实践2：在catch语句中调用Thread.currentThread().isInterrupted()来恢复设置中断状态
 * ，以便于在后续的执行中，依然能够检查到刚才发生了中断
 * 回到刚才RightWayStopThreadInProd补上中断，让它跳出
 * @Author zhangzx
 * @Date 2019/11/20 20:27
 * Version 1.0
 **/
public class RightWayStopThreadInProd2 implements Runnable{

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted,程序运行结束");
                break;
            }
            reInterrupt();
        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
