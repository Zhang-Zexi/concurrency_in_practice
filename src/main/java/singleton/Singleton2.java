package singleton;

/**
 * @ClassName Singleton2
 * @Description 恶汉式(静态代码块)(可用)
 * @Author zhangzx
 * @Date 2019/11/23 12:46
 * Version 1.0
 **/
public class Singleton2 {

    private final static Singleton2 INSTANCE ;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
