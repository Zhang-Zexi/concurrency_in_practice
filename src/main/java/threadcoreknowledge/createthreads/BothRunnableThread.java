package threadcoreknowledge.createthreads;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @ClassName BothRunnableThread
 * @Description 同时使用Runnale和Thread两种实现线程的方式
 * @Author zhangzx
 * @Date 2019/11/20 16:27
 * Version 1.0
 **/
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自Thread方法");
            }
        }.start();
    }
}
