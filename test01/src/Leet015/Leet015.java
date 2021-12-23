package Leet015;

import java.util.*;
import java.util.stream.IntStream;

public class Leet015 {
    public static void main(String[] args) {
        int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        Leet015 l15 = new Leet015();
        l15.threeSum2(nums);
        System.out.println("    ");
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int L = 0, R = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            L = i +1;
            R = nums.length - 1;
            for (int j = 0; L < R; j++) {
                if (L- 1 != i && nums[L] == nums[L - 1]) {
                    L++;
                    continue;
                } else if (R + 1 != i && R != nums.length - 1 && nums[R] == nums[R + 1]) {
                    R--;
                    continue;
                } else if (L >= R) {
                    break;
                }
                sum = nums[i] + nums[L] + nums[R];
                if (sum < 0) {
                    L++;
                    continue;
                } else if (sum > 0) {
                    R--;
                    continue;
                }else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[L]);
                    tmp.add(nums[R]);
                    ans.add(tmp);
                    L++;
                    R--;
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.clear();
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (list.contains(-nums[i] - nums[j])) {
                    List<Integer> tmp = new ArrayList<>();
                    int a = -(nums[i] + nums[j]);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(a);
                    ans.add(tmp);
                }
                list.add(nums[j]);
            }
        }
        return ans;
    }
}
