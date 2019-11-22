package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName CantCatchDirectly
 * @Description 演示打印main，Thread-0，Thread1
 * @Author zhangzx
 * @Date 2019/11/21 20:40
 * Version 1.0
 **/
public class CantCatchDirectly implements Runnable {

    public static void main(String[] args) {
        new CantCatchDirectly().run();
        new Thread(new CantCatchDirectly()).start();
        new Thread(new CantCatchDirectly()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
