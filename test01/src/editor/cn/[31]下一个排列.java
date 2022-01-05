package editor.cn;//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1418 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
