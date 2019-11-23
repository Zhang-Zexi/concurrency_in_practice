package singleton;

/**
 * @ClassName Singleton3
 * @Description 懒汉式(线程安全)(不推荐)
 * @Author zhangzx
 * @Date 2019/11/23 12:46
 * Version 1.0
 **/
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {

    }

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
