package com.vucko.other;

/**
 * @author zhangpeipei
 * @date 2020/8/19 17:39
 */
public class BSTTree {


    public static void main(String[] args) {

//        int[] arr = {123,23,123,54,452,2,1};
//
//        Node root = new Node(6);
//        for (int i = 0; i < 10; i++) {
//            root = bstInsert(root, i);
//        }

        Node root = getTree();

        printTree(root);

        Node minNode = bstMin(root);
        System.out.println("Min Node : " + minNode.getValue());

        Node maxNode = bstMax(root);
        System.out.println("Max Node : " + maxNode.getValue());

        bstDelete(root, null, 20);

        printTree(root);
    }

    private static Node getTree() {
        Node a15 = new Node(15);
        Node a10 = new Node(10);
        Node a20 = new Node(20);
        Node a18 = new Node(18);
        a15.left = a10;
        a10.left = new Node(8);
        a10.right = new Node(12);
        a15.right = a20;
        a20.left = a18;
        a20.right = new Node(30);
        a18.left = new Node(16);
        a18.right = new Node(19);
        return a15;
    }

    private static void bstDelete(Node root, Node parent, int val) {

        if(root == null){
            return;
        }

        if(root.value > val){
            bstDelete(root.left, root, val);
        }else if(root.value < val){
            bstDelete(root.right, root, val);
        } else{
            // 删除的是叶子节点
            if(root.left == null && root.right == null){
                if(parent == null){
                    return;
                }
                if(parent.value > root.value){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
            // 删除节点左节点不为空
            else if(root.left != null && root.right == null){
                if(parent == null){
                    root = root.left;
                }
                if(parent.value > root.value){
                    parent.left = root.left;
                }else{
                    parent.right = root.left;
                }

            }
            // 删除节点右节点不为空
            else if(root.left == null && root.right != null){
                if(parent == null){
                    root = root.right;
                }
                if(parent.value > root.value){
                    parent.left = root.right;
                }else{
                    parent.right = root.right;
                }
            }
            // 删除节点左右节点都不为空，寻找左树最大值替换当前节点位置
            else{

                Node maxLeft = bstMax(root.left);
                bstDelete(root.left, root, maxLeft.value);

                maxLeft.right = root.right;
                maxLeft.left = root.left;
                if(parent.value > root.value){
                    parent.left = maxLeft;
                }else{
                    parent.right = maxLeft;
                }
            }

        }

    }

    private static Node bstMax(Node root) {
        if(root.right == null){
            return root;
        }
        Node node = bstMax(root.right);
        if(node!= null){
            return node;
        }
        return null;
    }

    private static Node bstMin(Node root) {
        if(root.left == null){
            return root;
        }
        Node node = bstMin(root.left);
        if(node!= null){
            return node;
        }
        return null;
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
