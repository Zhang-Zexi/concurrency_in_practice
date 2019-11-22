package threadcoreknowledge.uncaughtexception;

import java.util.logging.*;

/**
 * @ClassName MyUncaughtExceptionHandler
 * @Description 自己的MyUncaughtExceptionHandler
 * @Author zhangzx
 * @Date 2019/11/22 10:39
 * Version 1.0
 **/
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
//        logger.log(Level.WARNING, "线程异常，终止了" + t.getId(), e);
//        System.out.println(name + "捕获了异常" + t.getName() + "异常" + e);
        logger.log(Level.WARNING, "线程异常，终止了" + t.getId());
        System.out.println(name + "捕获了异常" + t.getName() + "异常");
        // 一般公司有自己的报警系统，而不是这样暴露出线面
        // 如果不想暴露异常的内容，只要删除e就行了
    }
}
