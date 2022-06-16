package com.cskaoyan.ds.sx.day030;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author sx
 * @since 2022/05/16 18:54
 */

public class MyBSTree<T extends Comparable> {

    public Node root;
    private int size;

    //增
    public boolean add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("value is illegal");
        }
        if (root == null) {
            root = new Node(value);
            size++;
        }
        Node mid = root;
        Node midF = null;
        int compareTo = 0;
        while (mid != null) {
            compareTo = (mid.value).compareTo(value);
            if (compareTo > 0) {
                midF = mid;
                mid = mid.left;
            } else if (compareTo < 0) {
                midF = mid;
                mid = mid.right;
            } else if (compareTo == 0) {
                return false;
            }
        }
        if (compareTo > 0) {
            midF.left = new Node(value);
        } else midF.right = new Node(value);
        size++;
        return true;
    }

    //删
    public boolean remove(T value) {
        if (value == null) {
            throw new IllegalArgumentException("value is illegal");
        }
        if (root == null) {
            root = new Node(value);
            size++;
        }
        Node mid = root;
        Node midF = null;
        while (mid != null) {
            int compareTo = mid.value.compareTo(value);
            if (compareTo > 0) {
                midF = mid;
                mid = mid.left;
            } else if (compareTo < 0) {
                midF = mid;
                mid = mid.right;
            } else if (compareTo == 0) {
                break;
            }
        }
        if (mid == null) return false;
        if (mid.left != null && mid.right != null) {
            Node min = mid.right;
            Node minF = mid;
            while (min.left != null) {
                minF = min;
                min = min.left;
            }
            mid.value = min.value;
            mid = min;
            midF = minF;
        }
        Node ch = mid.left != null ? mid.left : mid.right;

        if (mid == null) {
            root = ch;
            size--;
            return true;
        }

        if (midF.left == null) {
            midF.right = ch;
        } else {
            midF.left = ch;
        }
        size--;
        return true;
    }

    public boolean replace(T newValue){
        root.value = newValue;
        return true;
    }
    public boolean isBST(Node root){
        List<T> list = new LinkedList<>();
        Node mid = root;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || mid != null){
            while (mid != null){
                stack.push(mid);
                mid = mid.left;
            }
            Node pop = stack.pop();
            list.add(pop.value);
            mid = pop.right;
        }
        T temp = list.get(0);
        for (T t : list) {
            int equals = temp.compareTo(t);
            if (equals > 0){
                return false;
            }
            temp = t;
        }
        return true;
    }
    @Override
    public String toString() {
        return "MyBSTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }
    }
}
