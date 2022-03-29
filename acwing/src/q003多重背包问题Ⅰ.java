import java.util.Scanner;

public class q003多重背包问题Ⅰ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        int[] s = new int[N+1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][M+1];
        dp[0][0] = 0;
        for(int i = 1; i<= N;i++){
            for (int j = 0; j <= M;j++){
                for(int k = 0; k*v[i] <= j&& k<=s[i];k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
