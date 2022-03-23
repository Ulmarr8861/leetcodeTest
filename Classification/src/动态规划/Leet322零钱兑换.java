package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Leet322零钱兑换 {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        Leet322零钱兑换 l = new Leet322零钱兑换();
        int a = l.coinChange(coins, amount);
        System.out.println();
    }


    //普通深度优先搜索
    //（超时）
    public int coinChange(int[] coins, int amount) {
        Arrays.parallelSort(coins);
        int result = pdf(coins, amount, 0);
        System.out.println();
        return result;
    }

    private int   pdf(int[] coins, int amount,int count) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return count;
        }

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            ++count;
            int k = pdf(coins, amount - coin, count);
            minCount = k < minCount ? k : minCount;
            count--;
        }
        return minCount;

    }


    //改进的深度优先搜索 （重要）
    public class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) {
                return -1;
            }
            if (rem == 0) {
                return 0;
            }
            if (count[rem - 1] != 0) {
                return count[rem - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }

    //动态规划
    public int coinChange3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }



}
