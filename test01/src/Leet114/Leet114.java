package Leet114;

import Leet101.TreeNode;

public class Leet114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        TreeNode root1 = new TreeNode(0);
        new Leet114().flatten(root1);
        System.out.println("==========");
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode rootRight = root.right;
        TreeNode node1 = dfs(root.left, root);
        dfs(rootRight, node1);
    }

    //node表示递归的节点
    //root表示叠加后的结果
    private TreeNode dfs(TreeNode node,TreeNode root) {
        if (node == null) {
            return root;
        }
        TreeNode nodeLeft = node.left;
        TreeNode nodeRight = node.right;
        root.right = node;
        root.left = null;
        TreeNode node1 = dfs(nodeLeft, root.right);
        TreeNode node2 = dfs(nodeRight, node1);
        return node2;
    }
}
