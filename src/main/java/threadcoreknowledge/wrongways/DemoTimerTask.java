package threadcoreknowledge.wrongways;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
/**
 * @ClassName DemoTimerTask
 * @Description 定时器创建线程
 * @Author zhangzx
 * @Date 2019/11/20 17:02
 * Version 1.0
 **/
@Slf4j
public class DemoTimerTask {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.info("{}", Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}
