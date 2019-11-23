package deadlock;

/**
 * @ClassName MustDeadLock
 * @Description 必定发生死锁的情况
 * @Author zhangzx
 * @Date 2019/11/23 15:34
 * Version 1.0
 **/
public class MustDeadLock implements Runnable {
    int flag = 1;

    //这两句是新建了两个对象，如果不加static，那么o1和o2就是MustDeadLock的成员变量，虽然是看上去是只创建了一次，但是不同实例的成员变量是相互独立的，所以每次创建新对象，其实都创建了一次o1和o2，所以作为锁也是独立的，所以不会死锁，这个是类锁和对象锁的区别
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        MustDeadLock r1 = new MustDeadLock();
        MustDeadLock r2 = new MustDeadLock();
        r1.flag = 1;
        r2.flag = 0;
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("线程1成功拿到两把锁");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("线程2成功拿到两把锁");
                }
            }

        }
    }
}
