package from700;

/**
 *  @author yihuier
 *  @Date 2020/11/7 12:26
 *  @Description
 */
public class Solution707 {

}

/**
 * 这个实现好像有点复杂，不太好
 */
class MyLinkedList {

    private Node head;

    private Node tail;

    private Node curNode;

    private int curIndex;

    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        curIndex = -1;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }

        curNode = index >= curIndex ? curNode : head;
        curIndex = index >= curIndex ? curIndex : 0;

        while (curIndex < index) {
            curNode = curNode.next;
            curIndex++;
        }

        return curNode.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (size == 0) {
            tail = head;
            curNode = head;
        }

        curIndex++;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            curIndex = 0;
            curNode = head;
        } else {
            tail.next = node;
        }
        tail = node;

        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        curNode = index > curIndex ? curNode : head;
        curIndex = index > curIndex ? curIndex : 0;

        while (curIndex < index - 1) {
            curNode = curNode.next;
            curIndex++;
        }

        Node node = new Node(val);
        node.next = curNode.next;
        curNode.next = node;
        curNode = node;
        curIndex++;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
            curNode = head;
            curIndex = 0;
            size--;
            return;
        }

        if (index == size - 1) {
            if (curNode == tail) {
                curNode = head;
                curIndex = 0;
            }

            while (curNode.next != tail) {
                curNode = curNode.next;
                curIndex++;
            }

            curNode.next = null;
            tail = curNode;
            size--;
            return;
        }

        curNode = index > curIndex ? curNode : head;
        curIndex = index > curIndex ? curIndex : 0;

        while (curIndex < index - 1) {
            curNode = curNode.next;
            curIndex++;
        }

        curNode.next = curNode.next.next;
        size--;
    }

    private class Node {

        public int val;

        public Node next;

        public Node() {}

        public Node(int x) {
            val = x;
        }

        public Node(int val, Node next) {
            this.val = val; this.next = next;
        }
    }
}



