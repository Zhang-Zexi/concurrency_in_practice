package singleton;

/**
 * @ClassName Singleton1
 * @Description 恶汉式(静态常量)(可用)
 * @Author zhangzx
 * @Date 2019/11/23 12:46
 * Version 1.0
 **/
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
