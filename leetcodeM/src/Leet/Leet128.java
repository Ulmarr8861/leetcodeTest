package Leet;

import java.util.*;

public class Leet128 {
    public static void main(String[] args) {
        int a = new Leet128().longestConsecutive(new int[]{-4,-6,0,3,7,2,5,8,4,6,0,1});
        System.out.println("==========");
    }

    //方法1： 只排序没去重
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int max = 0;
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, sum);

            if (nums[i] - nums[i - 1] == 1) {
                sum++;
                max = Math.max(max, sum);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                max = Math.max(max, sum);
                sum = 1;
            }
        }
        return max;
    }

    //排序加去重
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        //排序
        Arrays.sort(nums);
        //去重(TreeSet有存入顺序 ，HashSet没有)
        Set<Integer> set = new TreeSet<>();
        for (Integer num : nums) {
            set.add(num);
        }

        int max = 0;
        int sum = 1;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            max = Math.max(max, sum);
            if (set.contains((int) iterator.next() - 1)) {
                sum++;
                max = Math.max(max, sum);
            } else {
                sum = 1;
            }
        }
        return max;
    }
}
