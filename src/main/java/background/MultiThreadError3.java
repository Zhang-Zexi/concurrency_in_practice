package background;

import java.util.*;

/**
 * @ClassName MultiThreadError3
 * @Description 发布逸出
 * @Author zhangzx
 * @Date 2019/11/22 14:42
 * Version 1.0
 **/
public class MultiThreadError3 {

    private Map<String, String> states;

    public MultiThreadError3() {
        states = new HashMap<>();
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周四");
    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        MultiThreadError3 multiThreadError3 = new MultiThreadError3();
        Map<String, String> states = multiThreadError3.getStates();
        states.get("1");
        System.out.println(states.get("1"));
        states.remove("1");
        System.out.println(states.get("1"));
    }
}
