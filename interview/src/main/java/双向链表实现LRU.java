import java.util.HashMap;

public class 双向链表实现LRU {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;

        public void addToHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public void removeFromTail() {
            if (tail == null) {
                return;
            }
            if (tail.prev == null) {
                head = null;
                tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;
        }

        public void remove(Node node) {
            if (node.prev == null) {
                head = node.next;
            } else {
                node.prev.next = node.next;
            }
            if (node.next == null) {
                tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }
        }
    }

    class LRUCache {
        int capacity;
        DoublyLinkedList list;
        HashMap<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            list = new DoublyLinkedList();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
            }
        }
    }
}