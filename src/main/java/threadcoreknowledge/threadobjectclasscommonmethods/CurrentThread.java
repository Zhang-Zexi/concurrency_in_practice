package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName CurrentThread
 * @Description 演示打印main，Thread-0，Thread1
 * @Author zhangzx
 * @Date 2019/11/21 20:40
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
