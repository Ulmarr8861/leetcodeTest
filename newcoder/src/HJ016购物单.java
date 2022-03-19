import java.util.*;
public class HJ016购物单{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int m=sc.nextInt();
        //前m个物品塞满容量为N的背包的最大总和
        int[][] dp=new int[m+1][N+1];
        int[][] price=new int[m+1][3];
        int[][] imp=new int[m+1][3];
        for(int i=1;i<=m;i++){
            int v=sc.nextInt();
            int p=sc.nextInt();
            int q=sc.nextInt();
            //主件
            if(q==0){
                price[i][0]=v;
                imp[i][0]=p;
            }
            else{
                //附件1
                if(price[q][1]==0){
                    price[q][1]=v;
                    imp[q][1]=p;
                }
                //附件2
                else{
                    price[q][2]=v;
                    imp[q][2]=p;
                }
            }
        }
        for(int i=1;i<=m;i++){
            //填满容量为N的背包
            for(int j=1;j<=N;j++){
                if(price[i][0]==0){
                    dp[i][j]=dp[i-1][j];
                }
                else{//第i个物品的价格超过背包容量j,此时不将物品放进背包
                    if(price[i][0]>j){
                        dp[i][j]=dp[i-1][j];
                    }
                    else{//取将第i个物品放进背包的总和与不将第i个物品放进背包的总和的最大值
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-price[i][0]]+price[i][0]*imp[i][0]);
                        //主件和附件1的价格之和小于当前背包容量时，取将第i个物品放进背包的总和与不将第i个物品放进背包的总和的最大值
                        if(price[i][0]+price[i][1]<=j){
                            dp[i][j]=Math.max(dp[i][j],dp[i-1][j-price[i][0]-price[i][1]]+price[i][0]*imp[i][0]+price[i][1]*imp[i][1]);
                        }
                        //主件和附件2的价格之和小于当前背包容量时，取将第i个物品放进背包的总和与不将第i个物品放进背包的总和的最大值
                        if(price[i][0]+price[i][2]<=j){
                            dp[i][j]=Math.max(dp[i][j],dp[i-1][j-price[i][0]-price[i][2]]+price[i][0]*imp[i][0]+price[i][2]*imp[i][2]);
                        }
                        //主件，附件1以及附件2放进背包的价格之和小于当前背包容量时，取将第i个物品放进背包的总和与不将第i个物品放进背包的总和的最大值
                        if(price[i][0]+price[i][1]+price[i][2]<=j){
                            dp[i][j]=Math.max(dp[i][j],dp[i-1][j-price[i][0]-price[i][1]-price[i][2]]+price[i][0]*imp[i][0]+price[i][1]*imp[i][1]+price[i][2]*imp[i][2]);
                        }
                    }
                }
            }
        }
        System.out.println(dp[m][N]);
    }
}
