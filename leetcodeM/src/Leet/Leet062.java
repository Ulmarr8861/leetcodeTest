package Leet;

public class Leet062 {
    static int result = 0;

    public static void main(String[] args) {
        int m = 3, n = 2;
        int times = new Leet062().uniquePaths2(m, n);
        System.out.println(times);

    }

    //方法1，应该没问题
    public int uniquePaths(int m, int n) {
        dfs(m, n, true);
        dfs(m, n, false);
        return result;
    }


    /**
     * @param m         行
     * @param n         列
     * @param direction true：下移。fasle：右移。
     */
    private void dfs(int m, int n, boolean direction) {

        if (direction && m > 1) {
            m--;

        } else if (!direction && n > 1) {
            n--;
        }
        if (m > 1) {
            dfs(m, n, true);

        }
        if (n > 1) {
            dfs(m, n, false);
        }
        if (m == 1 && n == 1) {
            result++;
            return;
        }
    }

    //方法2，应该没问题(重点掌握这个)
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
