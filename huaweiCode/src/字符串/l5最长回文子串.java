package 字符串;

import java.util.Locale;

public class l5最长回文子串 {
    public static void main(String[] args) {
        l5最长回文子串 l = new l5最长回文子串();
        String s= l.longestPalindrome("babad");
        System.out.println(s);
    }
    public String longestPalindrome(String s) {
        int[] ans = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int[] ans1 = pdf(s, i, i);
            int[] ans2 = pdf(s, i, i + 1);
            if (ans2[1] - ans2[0] > ans1[1] - ans1[0]) {
                ans = ans[1] - ans[0] > ans2[1] - ans2[0] ? ans : ans2;
            } else {
                ans = ans[1] - ans[0] > ans1[1] - ans1[0] ? ans : ans1;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    private int[] pdf(String s, int l, int r) {
        if (s.charAt(l) != s.charAt(r)) {
            return new int[2];
        }
        int left = l;
        int right = r;
        while (right >= 0 && left < s.length() && s.charAt(right) == s.charAt(left)) {
            right--;
            left++;
        }
        left--;
        right++;

        int len = left - right;
        return new int[]{l - (len) / 2,r+(len)/2};
    }

}
