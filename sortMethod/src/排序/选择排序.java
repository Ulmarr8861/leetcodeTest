package 排序;

/**
 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 重复第二步，直到所有元素均排序完毕。
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] a = method2(new int[]{3, 9, -1, 10, 20});
        System.out.println();

    }

//    优化：一次排序两个值，最大和最小值。
    public static int[] method2(int[] nums) {
        for (int i = 0; i < Math.ceil((double) nums.length / 2); i++) {
            int minIndex = i;
            int maxIndex = i;
            for (int j = i; j < nums.length-1-i; j++) {
//                if (nums[minIndex] > nums[j + 1]) {
//                    minIndex = j+1;
//                }
                minIndex = nums[minIndex] > nums[j + 1] ? j + 1 : minIndex;
                maxIndex = nums[maxIndex] < nums[j + 1] ? j + 1 : maxIndex;
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;

            tmp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[maxIndex];
            nums[maxIndex] = tmp;
        }
        return nums;
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
