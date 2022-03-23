package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class Leet118杨辉三角 {
    public static void main(String[] args) {
        List<List<Integer>> a = Leet118杨辉三角.generate(5);
        System.out.println();

    }
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        if (numRows == 1) {
            return ans;
        }
        for (int i = 2; i <= numRows; i++) {//i代表层，从第二层开始
            List<Integer> sed = new ArrayList<>();
            for (int j = 1; j <= i; j++) {//j代表第几个数，从1开始
                if (j == 1 || j == i) {
                    sed.add(ans.get(i - 2).get(0));
                }else {
                    sed.add(ans.get(i - 2).get(j - 2) + ans.get(i - 2).get(j-1));
                }
            }
            ans.add(sed);
        }
        return ans;
    }
}
