package Leet020;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leet020 {
    public Boolean method01(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < length; i++) {
            Character cur = s.charAt(i);
            if (map.containsKey(cur)) {
                if (stack.isEmpty()  || stack.peek() != map.get(cur)) {
                    return false;
                }
                stack.pop();
            }else{
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }
}
