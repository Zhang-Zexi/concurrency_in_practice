package jmm;

/**
 * @ClassName FieldVisibility
 * @Description 演示可见性带来的问题
 * @Author zhangzx
 * @Date 2019/11/22 19:41
 * Version 1.0
 **/
public class FieldVisibility {

    int a = 1;
    int abc = 1;
    int  abcd = 1;
    volatile int b = 2;

    private void change() {
        abc = 7;
        abcd = 70;
        a = 3;
        b = 0;// 起到触发器的作用
    }


    private void print() {
        if (b == 0) {// 根据happen-before原则，它一定能看到写入之前的操作
            // 这样的打印的值a,abc,abcd都是最新的，这样就起到了触发器的作用
            System.out.println("b=" + b + ";a=" + a);
        }
    }

    public static void main(String[] args) {
        while (true) {
            FieldVisibility test = new FieldVisibility();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }

    }


}