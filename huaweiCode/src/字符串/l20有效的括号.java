package 字符串;

import java.util.*;

public class l20有效的括号 {
    public static void main(String[] args) {
        System.out.println(new l20有效的括号().isValid("(){}}{"));
    }
    public boolean isValid(String s) {

        Deque<Character> deque = new ArrayDeque<>();
        Map<Character,Character> map  = new HashMap<>();
        map.put(')', '(');
        map.put(']','[');
        map.put('}','{');
        if (map.containsKey(s.charAt(0))) {
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            Character cur = s.charAt(i);
            if (map.containsKey(cur)) {
                if (deque.isEmpty()||!deque.peek().equals(map.get(cur))) {
                    return false;
                }
                deque.pop();
            } else {
                deque.push(cur);
            }
        }
        return deque.isEmpty();
    }
}
