package Leet055;

public class Leet055 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0, 4};
        Leet055 leet055 = new Leet055();
        boolean a = leet055.canJump(nums);
        System.out.println("2222");
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = 0;
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }
}
