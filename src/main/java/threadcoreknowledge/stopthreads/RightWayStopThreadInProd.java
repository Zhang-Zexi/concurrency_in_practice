package threadcoreknowledge.stopthreads;

/**
 * @ClassName RightWayStopThreadInProd
 * @Description 最佳实践：catchInterrupedException之后的优先选择，在方法签名中抛出异常
 * @Author zhangzx
 * @Date 2019/11/20 20:27
 * Version 1.0
 **/
public class RightWayStopThreadInProd implements Runnable{
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                // 保存日志、停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
            Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
