package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName Join
 * @Description 演示join，注意语句输出顺序，会变化
 * @Author zhangzx
 * @Date 2019/11/21 19:50
 * Version 1.0
 **/
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread.start();
        thread2.start();
        System.out.println("开始等待子线程运行完毕");
//        thread.join();
//        thread2.join();
        System.out.println("所有子线程执行完毕");//此句会等待thread/thread2先完成
    }
}
