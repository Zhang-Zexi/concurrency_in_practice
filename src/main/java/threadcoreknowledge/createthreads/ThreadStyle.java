package threadcoreknowledge.createthreads;

/**
 * @ClassName ThreadStyle
 * @Description 用Thread方式实现线程
 * @Author zhangzx
 * @Date 2019/11/20 16:11
 * Version 1.0
 **/
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread类创建线程");
    }

    public static void main(String[] args) {
        new Thread().start();
    }
}
