package Leet055;

public class Leet055 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Leet055 leet055 = new Leet055();
        boolean a = leet055.canJump(nums);
        System.out.println("2222");
    }
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int k = 0;
        int index = 0;
        while (k < nums.length) {
            for (int i = k; i < nums.length; i = nums[i]) {
                if (i == nums.length - 1) {
                    return true;
                }
                if (i > nums.length || nums[i] == 0) {
                    break;
                }
            }
            k++;
        }
        return false;
    }
}
