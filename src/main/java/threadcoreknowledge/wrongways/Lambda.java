package threadcoreknowledge.wrongways;

/**
 * @ClassName Lambda
 * @Description Lambda表达式创建线程
 * @Author zhangzx
 * @Date 2019/11/20 17:10
 * Version 1.0
 **/
public class Lambda {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
