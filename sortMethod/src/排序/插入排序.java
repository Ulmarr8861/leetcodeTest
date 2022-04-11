package 排序;

import java.util.ArrayList;
import java.util.List;

public class 插入排序 {
    public static void main(String[] args) {
        method(new int[]{3, 9, -1, 10, 20});
    }

    public static int[] method(int[] nums){
        int minIndex = 0;
        int tmp = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            minIndex = i-1;
            cur = i;
            while (minIndex >= 0) {
                if (nums[cur] < nums[minIndex]) {
                    tmp = nums[minIndex];
                    nums[minIndex] = nums[cur];
                    nums[cur] = tmp;
                    cur = minIndex;
                }
                minIndex--;
            }

        }
        return nums;
    }
}
