package threadcoreknowledge.stopthreads;

/**
 * @ClassName RunThrowException
 * @Description run无法抛出checked Exception，只能用try/catch
 * @Author zhangzx
 * @Date 2019/11/20 20:38
 * Version 1.0
 **/
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
