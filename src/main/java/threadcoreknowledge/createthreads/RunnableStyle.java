package threadcoreknowledge.createthreads;

/**
 * @ClassName RunnableStyle
 * @Description 用Runnable方式创建线程
 * @Author zhangzx
 * @Date 2019/11/20 16:09
 * Version 1.0
 **/
public class RunnableStyle implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable接口实现线程");
    }
}
