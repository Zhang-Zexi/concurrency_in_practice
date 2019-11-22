package threadcoreknowledge.uncaughtexception;

/**
 * @ClassName ExceptionInChildThread
 * @Description 单线程，抛出，处理异常堆栈；多线程，子线程发生异常，会有什么不同？
 * @Author zhangzx
 * @Date 2019/11/22 10:07
 * Version 1.0
 **/
public class ExceptionInChildThread implements Runnable {

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i < 1000; i ++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
