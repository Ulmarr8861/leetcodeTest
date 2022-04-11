package 排序;

public class 选择排序 {
    public static void main(String[] args) {
        method(new int[]{3, 9, -1, 10, 20});
    }
    public static int[] method(int[] nums) {
        int minIndex = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }
}
