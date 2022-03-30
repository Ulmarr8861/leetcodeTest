package 字符串;

import java.util.Arrays;

public class l43字符串相乘 {
    public static void main(String[] args) {
        String s = new l43字符串相乘().multiply("2", "3");
        System.out.println(s);
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuffer buffer = new StringBuffer();

        int tmp = 0;
        int res = 0;
        int[][] dp = new int[2][2];
        Arrays.sort(dp,(v1,v2)->
        {if (v1[0]==v2[0]){return v1[1]-v2[1];}
            return v1[0]-v2[0];}
        );
        num1 = buffer.append(num1).reverse().toString();
        buffer.delete(0, buffer.length());
        num2 = buffer.append(num2).reverse().toString();
        buffer.delete(0, buffer.length());

        int[] ans = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int index = 0;
            for (int j = 0; j < num2.length(); j++) {
                tmp = (num1.charAt(i) - '0')*(num2.charAt(j)-'0');
                res = tmp % 10 + index;
                index = tmp / 10;
                ans[i + j] += res;
                if (ans[i + j] / 10 > 0) {
                    ans[i + j + 1] += ans[i + j] / 10;
                    ans[i + j] = ans[i + j] % 10;
                }
                if (index != 0&&j==num2.length()-1) {
                    ans[i + j + 1] += index;
                }
            }

        }
        int k = ans.length - 1;
        while (ans[k] == 0) {
            k--;
        }
        for (int i = k; i>=0; i--){


            buffer.append(ans[i]);
        }
        return buffer.toString();
    }
}
