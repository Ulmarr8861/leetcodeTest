package Leet;

public class Leet070 {
    public static void main(String[] args) {
        int result = new Leet070().climbStairs(7);
        System.out.println(result);
    }
    //本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
    //1.爬上 n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
    //2.爬上 n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
