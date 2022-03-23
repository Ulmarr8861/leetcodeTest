package 动态规划;

public class Leet1277统计全为一的正方形子矩阵 {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {//第一行和第一列的，只能各自构成一个正方形
                        dp[i][j] = 1;
                        ans++;
                        continue;
                    }
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]),
                            dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }


}
