package 排序;

public class 冒泡排序 {
    public static void main(String[] args) {
        method(new int[]{3, 9, -1, 10, 20});
    }
    public static int[] method(int[] nums){
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ( j+1 < nums.length&&nums[j] > nums[j + 1]) {
                    tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    } 
}
