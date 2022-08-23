package Leet;

import java.util.ArrayList;
import java.util.List;

public class Leet039 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return result;
    }

    private void dfs(int[] candidates, int u, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = u; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                dfs(candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }

}
