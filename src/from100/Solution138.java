package from100;

import java.util.HashMap;
import java.util.Map;

/**
 *  @author yihuier
 *  @Date 2020/11/5 16:50
 *  @Description
 */
public class Solution138 {

    /**
     * 先一遍创建结点以及next
     * 然后再一个结点一个结点的设置random结点（十分麻烦）
     */
    public Node copyRandomList1(Node head) {
        Node sentry = new Node(0);
        Node cur = sentry;
        Node tmp = head;

        while (tmp != null) {
            Node node = new Node(tmp.val);
            cur.next = node;
            cur = node;
            tmp = tmp.next;
        }


        tmp = head;
        cur = sentry.next;
        while (tmp != null) {
            if (tmp.random == null) {
                tmp = tmp.next;
                cur = cur.next;
                continue;
            }

            Node node1 = head;
            Node node2 = sentry.next;
            while (node1 != tmp.random) {
                node1 = node1.next;
                node2 = node2.next;
            }
            cur.random = node2;

            tmp = tmp.next;
            cur = cur.next;
        }

        return sentry.next;
    }

    /**
     * 通过一个map来保存 原链表中的结点 -> 新链表中对应结点
     */
    public Node copyRandomList(Node head) {
        Node sentry = new Node(0);
        Node cur = sentry;

        Map<Node, Node> map = new HashMap<>();

        while (head != null) {
            // 创建结点（如果创建过了就直接获取）
            Node node = map.get(head);
            if (node == null) {
                node = new Node(head.val);
                map.put(head, node);
            }

            // 设置random结点
            Node random = null;
            if (head.random != null) {
                random = map.get(head.random);
                if (random == null) {
                    random = new Node(head.random.val);
                    map.put(head.random, random);
                }
            }
            node.random = random;

            // 将该结点加到链表中
            cur.next = node;
            cur = node;

            head = head.next;
        }

        return sentry.next;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
