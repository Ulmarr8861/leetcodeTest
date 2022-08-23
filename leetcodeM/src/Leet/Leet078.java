package Leet;

import java.util.ArrayList;
import java.util.List;

public class Leet078 {
    public static void main(String[] args) {
        Leet078 leet078 = new Leet078();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = leet078.subsets(nums);
        System.out.println("333");
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, path, 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> path, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, path, ++index);
        index--;
        path.add(nums[index]);
        dfs(nums, path, ++index);
        index--;
        path.remove(path.size() - 1);
    }



    //别人的方法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            dfs(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
