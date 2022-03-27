package 递归;

import java.util.LinkedList;
import java.util.Queue;

public class l112路径总和 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
//                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3));
        l112路径总和 l = new l112路径总和();
        boolean result = l.hasPathSum(root, 22);
        System.out.println("");

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pdf(root, targetSum);
    }

    private boolean pdf(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        boolean a1 = false, a2=false;
            a1 = pdf(root.left, targetSum - root.val);
            a2 = pdf(root.right, targetSum - root.val);
        return a1 || a2;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}
