/*
优化思路：  二进制优化
第i个物品最多选s个， 可以表示为 i个物品选1个、2个、4个、8个、16个直到小于s的2的幂次
由此转换成0 1背包问题。
S == 2000, logS = 11
时间复杂度 1000 * 11 * 2000 = 2 * 10^7
*/
import java.io.*;
class Main{
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        String[] ss = read.readLine().split(" ");
        int n = Integer.valueOf(ss[0]);
        int m = Integer.valueOf(ss[1]);
        //物品个数S == 2000, logS = 11
        int[] v = new int[n * 12];
        int[] w = new int[n * 12];
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            ss = read.readLine().split(" ");
            int a = Integer.valueOf(ss[0]);
            int b = Integer.valueOf(ss[1]);
            int s = Integer.valueOf(ss[2]);
            int k = 1;
            while(k <= s){
                cnt++;
                v[cnt] = a * k;
                w[cnt] = b * k;
                s -= k;
                k <<=  1;
            }
            if(s > 0){
                cnt++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
        }

        n = cnt;
        int[] dp = new int[m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = m; j >= v[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[m]);
    }
}
