package threadcoreknowledge.uncaughtexception;

/**
 * @ClassName CantCatchDirectly
 * @Description 1.不加try/catch抛出4个异常，都带线程名字
 * 2. 加了try/catch，期望捕获第一个线程异常，线程234不应该运行，希望打印caughtExcetpion
 * 3.执行发现，根本没有caughtExcetion,线程依然运行并且抛出异常
 * <p>
 * 说明线程的异常不能用传统方法捕获
 * @Author zhangzx
 * @Date 2019/11/22 10:12
 * Version 1.0
 **/
public class CantCatchDirectly implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        try {
            new Thread(new CantCatchDirectly(), "MyThread-1").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-2").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-3").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-4").start();
            Thread.sleep(300);
        } catch (RuntimeException e) {
            System.out.println("Caught Exception.");
        }
    }
    @Override
    public void run() {
        try {
            throw new RuntimeException();
        } catch(RuntimeException e) {
            System.out.println("Caught Exception.");
        }
    }
}
