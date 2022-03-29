package Leet098;

import Nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leet098 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        boolean a = new Leet098().isValidBST2(root);
        System.out.println("2");
    }

    int k = 0;

    public boolean isValidBST(TreeNode root) {
        dfs(root, true);
        return k != 1;
    }

    private boolean dfs(TreeNode root, boolean judge) {
        if (!judge) {
            return false;
        }
        if (root == null) {
            return true;
        }
        if (root.left == null || root.left.val < root.val) {
            dfs(root.left, judge);
        } else {
            k = 1;
            return dfs(root, false);
        }
        if (root.right == null || root.right.val > root.val) {
            dfs(root.right, judge);
        } else {
            k = 1;
            dfs(root, false);
        }
        return true;
    }


    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
