package Leet053;

public class Leet053 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int per = 0;
        for (int x : nums) {
            per = Math.max(per + x, x);
            result = Math.max(result, per);
        }
        return result;
    }
}
