package threadcoreknowledge.createthreads.wrongways;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPool5
 * @Description 创建线程的方式
 * @Author zhangzx
 * @Date 2019/11/20 16:39
 * Version 1.0
 **/
@Slf4j
public class ThreadPool5 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i ++) {
            executorService.submit(new ThreadPool5.Task() {
            });
        }
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500);
                log.info("{}", Thread.currentThread().getName());
            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName());
                log.info("exception", e);
            }
        }
    }
}
