package threadcoreknowledge.uncaughtexception;

/**
 * @ClassName UserOwnUncaughtExceptionHandler
 * @Description 使用刚才自己写的UncaughtExceptionHander
 * @Author zhangzx
 * @Date 2019/11/22 10:47
 * Version 1.0
 **/
public class UserOwnUncaughtExceptionHandler implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));
        new Thread(new UserOwnUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UserOwnUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UserOwnUncaughtExceptionHandler(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UserOwnUncaughtExceptionHandler(), "MyThread-4").start();
        Thread.sleep(300);
    }
    @Override
    public void run() {
            throw new RuntimeException();
    }
}
