package Leet;

import java.util.Arrays;

//多数元素
public class Leet169求众数 {
    //排序法
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


}
