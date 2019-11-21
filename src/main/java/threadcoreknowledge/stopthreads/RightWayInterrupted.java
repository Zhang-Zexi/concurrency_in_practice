package threadcoreknowledge.stopthreads;

/**
 * @ClassName RightWayInterrupted
 * @Description 注意Thread.interrpupted()方法的目标对象是"当前线程"，
 * 而不管本方法来自于哪个对象
 * @Author zhangzx
 * @Date 2019/11/21 11:29
 * Version 1.0
 **/
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        //获取中断标志并重置
        //static boolean interrupted目标对象是当前运行的线程，不管它是哪个实例调用的
        //实际执行它的是主函数
        System.out.println("isInterrupted: " + threadOne.interrupted());// 这个方法目标对象是当前运行的线程
        //获取中断标志并重直
        System.out.println("isInterrupted: " + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
