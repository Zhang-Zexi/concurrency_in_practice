package singleton;

/**
 * @ClassName Singleton3
 * @Description 静态内部类方法，可用
 * @Author zhangzx
 * @Date 2019/11/23 12:46
 * Version 1.0
 **/
public class Singleton7 {

    private Singleton7() {

    }

    private static class SingletonInstance {

        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        // 只有当真正调用的时候，才能去创建实例，这样解决了恶汉的缺点，又保留了懒汉的优点
        return SingletonInstance.INSTANCE;
    }
}
