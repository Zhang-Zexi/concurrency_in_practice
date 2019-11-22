package background;

import java.util.*;

/**
 * @ClassName MultiThreadsError3
 * @Description 发布逸出
 * @Author zhangzx
 * @Date 2019/11/22 14:42
 * Version 1.0
 **/
public class MultiThreadsError3 {

    private Map<String, String> states;

    public MultiThreadsError3() {
        states = new HashMap<>();
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周四");
    }

    public Map<String, String> getStates() {
        return states;
    }

    public Map<String, String> getStatesImproved() {
        return new HashMap<>(states);
    }

    public static void main(String[] args) {
        MultiThreadsError3 multiThreadError3 = new MultiThreadsError3();
        Map<String, String> states = multiThreadError3.getStates();
//        states.get("1");
//        System.out.println(states.get("1"));
//        states.remove("1");
//        System.out.println(states.get("1"));
        //
        System.out.println(multiThreadError3.getStatesImproved().get("1"));
        //返回的对象是一个新的副本
        multiThreadError3.getStatesImproved().remove("1");
        System.out.println(multiThreadError3.getStatesImproved().get("1"));
    }
}
