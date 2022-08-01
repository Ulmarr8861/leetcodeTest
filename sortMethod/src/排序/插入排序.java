package 排序;

import java.util.ArrayList;
import java.util.List;

//插入排序的思路：
//
//（1）从第一个元素开始，该元素可以认为已经被排序。
//
//（2）取出下一个元素，在已经排序的元素序列中从后向前扫描。
//
//（3）如果该元素（已排序）大于新元素，则将该元素移动到下一个位置。
//
//（4）重复上一个步骤，直到找到已排序的元素小于或者等于新元素的位置，将新元素插入到该位置后，重复上面的步骤
public class 插入排序 {
    public static void main(String[] args) {
        int[] a = method2(new int[]{3, 9, -1, 10, 20});
        System.out.println();
    }

    //注意是j--，从第j向数组的首部循环
    public static int[] method2(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
        return nums;
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
