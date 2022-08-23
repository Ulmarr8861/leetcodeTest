package 二叉树遍历;

import java.util.ArrayList;
import java.util.List;

public class 前序遍历 {
    public static void preOrder(List<Integer> ans,TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preOrder(ans,root.left);
        preOrder(ans,root.right);
        return ;
    }


    public static void main(String[] args) {
        List<Integer> ans = new ArrayList();

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5, new TreeNode(6), new TreeNode()));
        后序遍历.nxtOrder(ans, root);
        System.out.println();
    }
}
