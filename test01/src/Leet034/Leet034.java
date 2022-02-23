package Leet034;

public class Leet034 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Leet034 leet034 = new Leet034();
        int[] result = leet034.searchRange(nums, target);
        System.out.println("222");
    }
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        if (len == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int l = 0;
        int r = len - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return searchRangeStep2(nums, mid, target);
            }
            if (nums[l] <= target && target < nums[mid]) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
            if (nums[mid] < target && target <= nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int[] searchRangeStep2(int[] nums, int mid, int target) {
        int l = mid, r = mid;
        while (l >= 0 && nums[l] == target) {
            l--;
        }
        while (r < nums.length && nums[r] == target) {
            r++;
        }
        return new int[]{l+1, r-1};

    }

}
