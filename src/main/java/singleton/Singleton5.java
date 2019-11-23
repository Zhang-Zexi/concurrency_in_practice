package singleton;

/**
 * @ClassName Singleton3
 * @Description 懒汉式(线程不安全)(不推荐)
 * @Author zhangzx
 * @Date 2019/11/23 12:46
 * Version 1.0
 **/
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
