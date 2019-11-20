package threadcoreknowledge.startthread;

/**
 * @ClassName CantStartTwice
 * @Description  演示不能两次调用start方法，否则会报错
 * @Author zhangzx
 * @Date 2019/11/20 18:17
 * Version 1.0
 **/
public class CantStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
