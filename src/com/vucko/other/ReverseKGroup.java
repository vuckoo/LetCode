package com.vucko.other;


/**
 * k个一组翻转单向链表
 *
 *  k=2 1>2>3>4>5>6>7  ==>  2>1>4>3>6>5>7
 *
 * @author zhangpeipei
 * @date 2020/8/11 16:48
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node cur = a;
        for (int i = 2; i < 12; i++) {
            Node b = new Node(i);
            cur.next = b;
            cur = cur.next;
        }
        print(a);

//        Node b = reverse(a, 2);
//        print(b);

        Node c = reverse(a, 3);
        print(c);
    }

    private static void print(Node a) {
        Node cur = a;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private static Node reverse(Node head, int k){
        Node a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if(b == null){
                return head;
            }
            b = b.next;
        }

        Node newHead = reversePart(a, b);
        a.next = reverse(b, k);
        return newHead;
    }

    private static Node reversePart(Node a, Node b) {
        Node cur = a;
        Node pre = null;
        Node next = null;
        while(cur != b){
            next = cur.next;
            cur.next = pre;
            // 移动指针
            pre = cur;
            cur = next;
        }
        return pre;
    }


    static class Node{

        private int val;

        private Node next;

        private Node pre;

        public Node(int i) {
            this.val = i;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }

}
