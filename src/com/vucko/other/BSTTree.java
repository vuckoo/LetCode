package com.vucko.other;

/**
 * @author zhangpeipei
 * @date 2020/8/19 17:39
 */
public class BSTTree {


    public static void main(String[] args) {

        int[] arr = {123,23,123,54,452,2,1};

        Node root = new Node(6);
        for (int i = 0; i < 10; i++) {
            root = bstInsert(root, i);
        }


        printTree(root);
    }

    private static void printTree(Node root) {
        if(root == null){
            return;
        }
        printTree(root.left);
        System.out.println(root.value);
        printTree(root.right);
    }

    private static Node bstInsert(Node root, int val) {

        if(root == null){
            return new Node(val);
        }

        if(root.value > val){
            root.left = bstInsert(root.left, val);
        }else{
            root.right = bstInsert(root.right,val);
        }

        return root;
    }


    static class Node{

        private int value;

        private Node left;

        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
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
