package 排序;

/**
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
 * 这步做完后，最后的元素会是最大的数。针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] a = method2(new int[]{3, 9, -1, 10, 20});
        System.out.println();
    }
    //三次优化：1、当我们执行完最后一个的时候，只有一个数字，没必要再执行这一趟了。：i < nums.length   ==>  i < nums.length-1
    //2、j < nums.length-1   ====>    j < nums.length-1-i;
    //3、标志位flag 当没交换的时候则证明排序完成
    public static int[] method2(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = 0;
                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                return nums;
            }
        }
        return nums;
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
