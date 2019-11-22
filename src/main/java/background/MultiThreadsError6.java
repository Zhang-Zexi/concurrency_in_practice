package background;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MultiThreadsError6
 * @Description 在构造函数中新建线程
 * @Author zhangzx
 * @Date 2019/11/22 15:10
 * Version 1.0
 **/
public class MultiThreadsError6 {
    private Map<String, String> states;

    public MultiThreadsError6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1", "周一");
                states.put("2", "周二");
                states.put("3", "周三");
                states.put("4", "周四");
            }
        });

    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        MultiThreadsError6 multiThreadsError6 = new MultiThreadsError6();

        System.out.println(multiThreadsError6.getStates().get("1"));
    }
}
