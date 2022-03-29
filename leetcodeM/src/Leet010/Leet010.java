package Leet010;

/**
最后来个归纳：
1.如果 p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1]；
2.如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
3.如果 p.charAt(j) == '*'：
    3.1.如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
    3.2.如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
        dp[i][j] = dp[i-1][j]       //in this case, a* counts as multiple a
        or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
        or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
 */
public class Leet010 {
    public static void main(String[] args) {
        String s = "abcd";
        String p = "a*";
        boolean c = new Leet010().isMatch(s, p);
        System.out.println("=====");
    }
    public boolean isMatch(String s, String p) {
        if (p == null) {
            return s == null;
        }

        if (s == null) {
            return p.length() <= 0;
        }


        int m = s.length() + 1;
        int n = p.length() + 1;

        boolean[][] dp = new boolean[m][n];

        dp[0][0] = true;
        for (int j = 2; j < n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int r = 1; r < m; r++) {
            int i = r - 1;
            for (int c = 1; c < n; c++) {
                int j = c - 1;
                //1.如果 p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1]；
                //2.如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[r][c] = dp[r - 1][c - 1];
                    //3.如果 p.charAt(j) == '*'：
                } else if (p.charAt(j) == '*') {
                    //    3.2.如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[r][c] = dp[r - 1][c] || dp[r][c - 2];
                    } else {
                        dp[r][c] = dp[r][c - 2];
                    }
                } else {
                    dp[r][c] = false;
                }

            }
        }
        return dp[m - 1][n - 1];
    }
}
