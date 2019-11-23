package deadlock;

import java.util.Random;
import deadlock.TransferMoney.Account;

/**
 * @ClassName MultiTransferMoney
 * @Description 多人同时转账，依然很危险
 * @Author zhangzx
 * @Date 2019/11/23 16:05
 * Version 1.0
 **/
public class MultiTransferMoney {

    private static final int NUM_ACCOUNTS = 5000;
    private static final int NUM_MONEY = 1000;
    private static final int NUM_ITERATIONS = 1000000;
    private static final int NUM_THREADS = 20;

    public static void main(String[] args) {
        Random rnd = new Random();
        Account[] accounts = new Account[NUM_ACCOUNTS];
        for (int i = 0; i < accounts.length; i ++) {
            accounts[i] = new Account(NUM_MONEY);
        }
        class ThransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i ++) {
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int amount = rnd.nextInt(NUM_MONEY);
                    TransferMoney.transferMoney(accounts[fromAcct], accounts[toAcct], amount);
                }
            }
        }
        for (int i = 0; i < NUM_THREADS; i ++) {
            new ThransferThread().start();
        }
    }
}
