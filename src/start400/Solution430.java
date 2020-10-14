package start400;

import util.Node;

/**
 *  @author yihuier
 *  @Date 2020/9/11 13:26
 *  @Description 链表展平
 */
public class Solution430 {

    public Node flatten(Node head) {
        Node current = head;

        while (current != null) {
            if (current.child != null) {
                Node child = current.child;

                // 这个循环是为了找出子节点的最后一个结点
                while (child.next != null) {
                    // 这个递归是关键
                    child = flatten(child);
                    // 我们假设从flatten返回的链表已经成功处理完成了，所以现在的不断后移直到最后一个结点
                    child = child.next;
                }

                // 下面是将子节点的第一个结点最后一个结点加入到当前的链表当中
                child.next = current.next;
                // 这里要注意判空
                if (current.next != null) {
                    current.next.prev = child;
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }
            current = current.next;
        }

        return head;
    }
}
