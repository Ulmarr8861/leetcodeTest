package Offer;

import Nodes.Node;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class offer036二叉搜索树转化为双向循环链表 {
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
