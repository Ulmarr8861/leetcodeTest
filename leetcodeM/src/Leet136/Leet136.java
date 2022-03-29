package Leet136;

import java.util.HashSet;
import java.util.Set;

public class Leet136 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int a = new Leet136().singleNumber2(nums);
        System.out.println(2);
    }
    //使用集合存储(运行速度慢)
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

    //位运算
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
