package com.vucko.alibaba;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 查询二叉搜索树(BST)中第k小的元素的值
 *
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 *
 * @author zhangpeipei
 * @date 2020/8/12 16:54
 */
public class FindKInBST {

    public static void main(String[] args) {
        Node a5 = new Node(5);
        Node a3 = new Node(3);
        Node a2 = new Node(2);

        a5.left = a3;
        a5.right = new Node(6);

        a3.left = a2;
        a3.right = new Node(4);

        a2.left = new Node(1);

        System.out.println(getK(a5, 5).getVal());

    }

    static Node getK(Node root, int k){
        AtomicInteger index = new AtomicInteger(0);
        Node node = fetchNode(root, k, index);
        return node;
    }

    private static Node fetchNode(Node root, int k, AtomicInteger index) {
        if(root == null){
            return null;
        }

        Node left = fetchNode(root.left, k, index);
        if(left != null){
            return left;
        }

        // 中序遍历
        if(index.get() == k-1){
            return root;
        }
        index.incrementAndGet();

        Node right = fetchNode(root.right, k, index);
        if(right != null){
            return right;
        }
        return null;
    }


    static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
