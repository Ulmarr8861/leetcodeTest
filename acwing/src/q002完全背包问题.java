import java.util.*;

public class q002完全背包问题 {


    //三个for循环
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[V + 1];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k * v[i] < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(dp[N + 1][V + 1]);
    }


    //改进


        public static void main2(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int V = sc.nextInt();
            int[] v = new int[N + 1];
            int[] w = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                v[i] = sc.nextInt();
                w[i] = sc.nextInt();
            }
            int[][] dp = new int[N + 1][V + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= V; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j>=v[i]){
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - v[i]] + w[i]);
                    }
                }
            }
            System.out.println(dp[N][V]);
        }


        //改进2
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[] dp = new int[V + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                    if (j>=v[i]) {
                        dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                    }

            }
        }
        System.out.println(dp[V]);
    }
}
