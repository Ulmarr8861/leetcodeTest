package Leet101;

public class Leet101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        boolean result = new Leet101().isSymmetric(root);
        System.out.println("===");
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return dfs(left, right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left!= null && right != null && left.val == right.val) {
            return dfs(left.left, right.right) && dfs(left.right,right.left);
        }
        return false;
    }
}
