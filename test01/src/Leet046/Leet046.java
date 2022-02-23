package Leet046;

import java.util.ArrayList;
import java.util.List;

public class Leet046 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Leet046 leet046 = new Leet046();
        List<List<Integer>> a = leet046.permute(nums);
        System.out.println("000");
    }
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int u) {
        if (u == nums.length) {

            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
            }
            dfs(nums, ++u);
            path.remove(path.size() - 1);
        }
    }
}
