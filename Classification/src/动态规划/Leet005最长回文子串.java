package 动态规划;

public class Leet005最长回文子串 {
    public static void main(String[] args) {
        String s = "abbbbad";
        Leet005最长回文子串 l5 = new Leet005最长回文子串();
        String result = l5.longestPalindrome2(s);
        System.out.println(result);

    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    public String longestPalindrome(String s) {
        char[] charArrays = s.toCharArray();
        int left, right = 0;
        int maxLen = 0;
        int len = 0;
        int startLen = 0;
        for (int i = 0; i < charArrays.length; i++) {
            left = i-1;
            right = i + 1;
            if (i == 0) {
                while (right < charArrays.length && charArrays[i] == charArrays[right]) {
                    right++;
                }
                maxLen = right;
                continue;
            }

            while (left > 0 && charArrays[i] == charArrays[left]) {
                left--;
            }
            while (right < charArrays.length && charArrays[i] == charArrays[right]) {
                right++;
            }
            while (left >= 0 && right < charArrays.length && charArrays[left] == charArrays[right]) {
                left--;
                right++;
            }
            len = right - left - 1;
            if (len > maxLen) {
                maxLen = len;
                startLen = left + 1;
            }
        }
        return s.substring(startLen, startLen + maxLen);
    }

}
