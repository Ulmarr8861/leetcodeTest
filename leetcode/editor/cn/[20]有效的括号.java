 //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2751 👎 0


 import java.util.ArrayDeque;
 import java.util.Deque;
 import java.util.HashMap;
 import java.util.Map;

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     public boolean isValid(String s) {
         Deque<Character> deque = new ArrayDeque<>();
         Map<Character,Character> map  = new HashMap<>();
         map.put(')', '(');
         map.put(']','[');
         map.put('}','{');

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
//leetcode submit region end(Prohibit modification and deletion)
