package threadcoreknowledge.wrongways;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName AnonymousInnerClassDemo
 * @Description
 * @Author zhangzx
 * @Date 2019/11/20 17:07
 * Version 1.0
 **/
@Slf4j
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                log.info("{}", Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("{}", Thread.currentThread().getName());
            }
        }).start();
    }
}
