//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2144 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        addParenthesis(ans, n, 0, 0, new StringBuffer());
        return ans;
    }

    public void addParenthesis(List<String> ans, int n, int left, int right, StringBuffer tmp) {
        if (tmp.length() == n * 2) {
            ans.add(tmp.toString());
            return;
        }
        if (left < n) {
            tmp.append("(");
            addParenthesis(ans, n, left + 1, right, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        if (right < left) {
            tmp.append(")");
            addParenthesis(ans, n, left, right + 1, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
