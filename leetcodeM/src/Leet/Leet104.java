package Leet;


import Nodes.TreeNode;

public class Leet104 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2));
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        int deepth = new Leet104().maxDepth(root1);
        System.out.println(deepth);

    }
    static int maxLevel = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root,1);
        return maxLevel;
    }

    private void dfs(TreeNode root,int level) {
        if (root.left != null) {
            dfs(root.left,++level);
            --level;
        }
        if (root.right != null) {
            dfs(root.right, ++level);
        }
        if (root.left == null && root.right == null) {
            maxLevel = Math.max(maxLevel, level);
        }
    }
}
