package Leet;


import Nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leet102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        List<List<Integer>> result = new Leet102().levelOrder(root);
        System.out.println("=========");
    }
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        dfs(root, result, ++level);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }
        result.get(level-1).add(root.val);
        level++;
        dfs(root.left, result, level);
        dfs(root.right, result, level);
    }
}
