package Leet056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leet056 {
    public static void main(String[] args) {
        Leet056 leet056 = new Leet056();
        int[][] a =leet056.merge(new int[][]{{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 5}, {0, 3}});
        System.out.println("----");
    }
    //方法1，应该没问题
    public int[][] merge(int[][] intervals) {
        //先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        //遍历区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int index = 0;
        int start = 0;
        int end = 0;

        //遍历n-1次，遍历每个子数组
        for (int i = 0; i < intervals.length; i++) {
            //分为合并和不能合并两种情况
            //若当前子数组的起始位置大于比较位置的末位置，则不能合并并加入到List中
            if (intervals[i][0] > res.get(index)[1]) {
                res.add(intervals[i]);
                index++;
            } else {
                end = Math.max(res.get(index)[1], intervals[i][1]);
                start = res.get(index)[0];
                res.set(index, new int[]{start, end});
            }
        }
        //返回
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
