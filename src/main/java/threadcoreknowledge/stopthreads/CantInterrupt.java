package threadcoreknowledge.stopthreads;

/**
 * @ClassName CantInterrupt
 * @Description 如果while里面放try/catch,会导致中断失效
 * @Author zhangzx
 * @Date 2019/11/20 20:15
 * Version 1.0
 **/
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num ++;
                try {
                    Thread.sleep(10);// 没有满足循环跳出的条件
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(500);
        thread.interrupt();
    }
}
