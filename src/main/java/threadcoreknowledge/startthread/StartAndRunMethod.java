package threadcoreknowledge.startthread;

/**
 * @ClassName StartAndRunMethod
 * @Description 对比star和run两种启动线程的方式
 * @Author zhangzx
 * @Date 2019/11/20 18:09
 * Version 1.0
 **/
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run(); // main 打印的是主线程的方法名

        new Thread(runnable).start(); // thread
    }
}
