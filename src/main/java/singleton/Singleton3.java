package singleton;

/**
 * @ClassName Singleton3
 * @Description 懒汉式(静态不安全)(可用)
 * @Author zhangzx
 * @Date 2019/11/23 12:46
 * Version 1.0
 **/
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
