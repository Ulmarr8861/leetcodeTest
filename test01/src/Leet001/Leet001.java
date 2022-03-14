package Leet001;

import java.util.HashMap;
import java.util.Map;

public class Leet001 {
    public static void main(String[] args) {
        Leet001 leet001 = new Leet001();
        int[] nums = {3, 4, 5, 6, 7};
        int[] a = leet001.twoSum(nums, 10);
        System.out.println("===");
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
