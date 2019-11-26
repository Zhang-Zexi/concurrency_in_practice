package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName CurrentThread
 * @Description
 * @Author zhangzx
 * @Date 2019/11/25 20:47
 * Version 1.0
 **/
public class CurrentThread implements Runnable {
    public static void main(String[] args) {
        new CurrentThread().run();
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}