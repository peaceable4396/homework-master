package com.cskaoyan.ds.sx.day030;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author sx
 * @since 2022/05/17 19:26
 */

public class SymmetryTree<T> {
    public static void main(String[] args) {
        MyTree<Integer> tree = new MyTree<>();
        tree.root.value = 1;
        tree.getLeft(2, tree.root);
        tree.getLeft(3, tree.root.left);
        tree.getRight(4, tree.root.left);
        tree.getRight(2, tree.root);
        tree.getRight(3, tree.root.right);
        tree.getLeft(4, tree.root.right);
        System.out.println(tree.isSymmetry(tree.root));
        MyTree<Integer> tree2 = new MyTree<>();
        tree2.root.value = 1;
        tree2.getLeft(2, tree2.root);
        tree2.getLeft(3, tree2.root.left);
        tree2.getRight(4, tree2.root.left);
        tree2.getRight(2, tree2.root);
        tree2.getRight(4, tree2.root.right);
        tree2.getLeft(4, tree2.root.right);
        System.out.println(tree.isSymmetry(tree2.root));
        tree2.reverseTree(tree2.root);
        System.out.println(tree2);
    }

}
class MyTree<T> {
    public Node root = new Node();
    public int size;

    public boolean isSymmetry(Node root) {
        Node mid = root;
        Stack<Node> stack = new Stack<>();
        Deque<T> queue = new LinkedBlockingDeque<>();
        while (mid != null || !stack.isEmpty()) {
            while (mid != null) {
                stack.push(mid);
                mid = mid.left;
            }
            Node pop = stack.pop();
            queue.add(pop.value);
            mid = pop.right;
        }
        while (queue.size() != 1) {
            T front = queue.pollFirst();
            T end = queue.pollLast();
            if (!Objects.equals(front, end)) {
                return false;
            }
        }
        return true;
    }
    public void reverseTree(Node root){
        Node mid = root;
        Stack<Node> stack = new Stack<>();
        Stack<T> stack1 = new Stack<>();
        while (mid != null || !stack.isEmpty()) {
            while (mid != null) {
                stack.push(mid);
                mid = mid.left;
            }
            Node pop = stack.pop();
            stack1.add(pop.value);
            mid = pop.right;
        }
        mid = root;
        while (mid != null || !stack.isEmpty()) {
            while (mid != null) {
                stack.push(mid);
                mid = mid.left;
            }
            Node pop = stack.pop();
            pop.value = stack1.pop();
            mid = pop.right;
        }
    }
    public void getLeft(T value,Node root){
        root.left = new Node(value);
    }
    public void getRight(T value,Node root){
        root.right = new Node(value);
    }

    public class Node {
        T value;
        Node left;// 左子树
        Node right;// 右子树

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }
    }
}
