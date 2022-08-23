
public class 树转排序的双向链表 {
    class Solution {
        Node pre = null, head = null;

        public Node treeToDoublyList(Node root) {
            if (root == null) return root;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        void dfs(Node root) {
            if (root == null) return;
            dfs(root.left);
            if (pre != null) pre.right = root;
            else head = root;
            // 链表头结点
            root.left = pre;
            pre = root;
            dfs(root.right);
        }
    }
}
