package threadcoreknowledge.sixstates;

/**
 * @ClassName NewRunnableTerminated
 * @Description 展示线程的NEW、RUNNABLE、TERMINATED状态。即时是正在运行，也是Runnable，而不是RUNNING
 * @Author zhangzx
 * @Date 2019/11/21 14:35
 * Version 1.0
 **/
public class NewRunnableTerminated implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        // 打印NEW的状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印出Runnable状态，即时是正在运行也是Runnable，而不是Running
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i ++) {
            System.out.println(i);
        }
    }
}
