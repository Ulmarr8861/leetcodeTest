package 二叉树遍历;

import java.util.List;

public class 中序遍历 {
    public static void innerOrder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        innerOrder(ans, root.left);
        ans.add(root.val);
        innerOrder(ans, root.right);
        return;
    }
}
