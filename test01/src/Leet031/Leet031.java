package Leet031;

public class Leet031 {
    public static void main(String[] args) {
        int[] a = {2,3,1,3,3,2};
        Leet031 l31 = new Leet031();
        l31.nextPermutation(a);
        System.out.println("aa");
    }
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int n = nums.length;
        int flag = -1;
        int k = -1;
        int tmp = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n - 1; j++) {
                int res = Integer.MAX_VALUE;
                if (nums[i] < nums[j] && nums[j] < res) {
                    flag = j;
                    k = i;
                }
            }
            if (flag != -1) {
                break;
            }
        }
        if (flag != -1) {
            int temp1 = nums[k];
            nums[k] = nums[flag];
            nums[flag] = temp1;
        }

        // 把k后面的元素升序
        int i = flag == -1 ? 0 : k + 1;
        int j = n - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
