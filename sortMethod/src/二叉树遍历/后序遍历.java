package 二叉树遍历;

import java.util.List;

public class 后序遍历 {
    public static void nxtOrder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        nxtOrder(ans, root.left);
        nxtOrder(ans, root.right);
        ans.add(root.val);
        return;
    }
}
