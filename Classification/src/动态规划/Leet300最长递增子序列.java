package 动态规划;

public class Leet300最长递增子序列 {
    public static void main(String[] args) {
        int a = Leet300最长递增子序列.lengthOfLIS(new int[]{0,1,0,3,2,3});
        System.out.println();
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {//表示第几个数
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {//表示找比j数小的数
                if (nums[i] >= nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
