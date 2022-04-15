package Leet543;
/**
 * @author ulmarr8861
 * @date 2022/4/15
 */
public class Leet543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        int a = new Leet543().diameterOfBinaryTree(root);
        System.out.println();
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int le = deepth(root.left);
        int r = deepth(root.right);
        return le + r;
    }

    private int deepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_H = deepth(root.left);
        int right_H = deepth(root.right) ;
        return Math.max(left_H, right_H)+1;

    }
}
 class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

