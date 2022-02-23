//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4278 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int charArrayLength = charArray.length;
        int left, right;
        int maxLength =0;
        int len;
        int startLength = 0;
        for (int i = 0; i < charArrayLength; i++) {
            left = i - 1;
            right = i + 1;
            if (i == 0) {
                while (right < charArrayLength && charArray[i] == charArray[right]) {
                    right++;
                }
                maxLength = right;
                continue;
            }
            while (left >= 0 && charArray[left] == charArray[i]) {
                left--;
            }
            while (right < charArrayLength && charArray[right] == charArray[i]) {
                right++;
            }
            while (left >= 0 && right < charArrayLength && charArray[left] == charArray[right]) {
                left--;
                right++;
            }
            len = right - left - 1;
            if (len >= maxLength) {
                maxLength = len;
                startLength = left + 1;
            }
        }
        return s.substring(startLength, startLength + maxLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
