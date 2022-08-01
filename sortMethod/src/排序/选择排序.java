package 排序;

/**
 * 第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
 * 以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。”
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
