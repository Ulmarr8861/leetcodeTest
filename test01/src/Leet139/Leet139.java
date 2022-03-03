package Leet139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet139 {
    public static void main(String[] args) {
        String s = "abcd";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");
        boolean result = new Leet139().wordBreak2(s, wordDict);
        System.out.println(result);
    }


    //自己的方法超时
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        if (s.length() == 0) {
            return true;
        }
        String tmp = "";
        String next = "";
        for (int i = 0; i < s.length(); i++) {
            tmp = s.substring(0, i + 1);
            next = s.substring(i + 1);
            if (set.contains(tmp)) {
                if (wordBreak(next, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }


    //记住（解答的第一个）
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
