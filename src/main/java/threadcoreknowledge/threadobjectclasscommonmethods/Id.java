package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @ClassName Id
 * @Description ID从0开始，JVM运行起来以后，我们自己创建的线程ID早已不是0
 * @Author zhangzx
 * @Date 2019/11/21 20:52
 * Version 1.0
 **/
public class Id {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的ID " + Thread.currentThread().getId());
        System.out.println("子线程的ID " + thread.getId());
    }
}
