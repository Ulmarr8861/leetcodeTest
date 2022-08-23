package Leet;

import java.util.ArrayList;
import java.util.List;

public class Leet064 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int result = new Leet064().minPathSum2(grid);
        System.out.println(result);
    }
    static int minSum = Integer.MAX_VALUE;
    static List<int[]> grid1 = new ArrayList<>();
    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            grid1.add(grid[i]);
        }
        df(grid.length, grid[0].length, true, grid[0][0]);
        df(grid.length, grid[0].length, false,grid[0][0]);
        return minSum;
    }

    private void df(int down, int right, boolean direction,int sum) {
        sum = sum + grid1.get(down-1)[right-1];
        if (direction && down > 1) {
            down--;
        }
        if (!direction && right >1) {
            right--;
        }
        if (down > 1) {
            df(down, right, true,sum);
        }
        if (right > 1) {
            df(down, right, false,sum);
        }
        if (down == 1 && right == 1) {
            if (minSum == 0) {
                minSum = Math.max(minSum, sum);
            }
            minSum = Math.min(minSum, sum);
            return;
        }
    }


    //方法2，应该没问题(重点掌握这个)
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i ==0 && j==0) continue;
                else if (i == 0 ) grid[i][j] = grid[i][j] + grid[i][j - 1];
                else if (j == 0 ) grid[i][j] = grid[i][j] + grid[i - 1][j];
                else grid[i][j] = grid[i][j] + Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m-1][n-1];
    }
}
