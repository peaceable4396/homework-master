package com.cskaoyan.ds.sx.day029;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author sx
 * @since 2022/05/16 18:54
 */

public class MyBSTree<T extends Comparable> {

    private Node root;
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

    //栈先序遍历
    public LinkedList<T> firstOrder() {
        LinkedList<T> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            list.add(pop.value);
        }
        return list;
    }

    //递归先序遍历
    public LinkedList<T> firstOrder2() {
        LinkedList<T> list = new LinkedList<>();
        firstOrder2(root, list);
        return list;
    }

    public void firstOrder2(Node root, LinkedList<T> list) {
        if (root == null) {
            return;
        }
        list.add(root.value);
        firstOrder2(root.left, list);
        firstOrder2(root.right, list);
    }
    //中序先序建树
    public void build(LinkedList<T> listFirst, LinkedList<T> listMid){
        root = buildTreeBy(listFirst,listMid);
        size = listFirst.size();
    }
    private Node buildTreeBy(List<T> listFirst,List<T> listMid){
        if (listMid.size() == 0){
            return null;
        }
        if (listMid.size() == 1){
            return new Node(listMid.get(0));
        }
        int mid = listMid.indexOf(listFirst.get(0));
        T rootValue = listFirst.get(0);
        Node root = new Node(rootValue);
        List leftListMid = listMid.subList(0,mid);
        List leftListFirst = listFirst.subList(1,mid+1);
        Node left = buildTreeBy(leftListFirst,leftListMid);
        List rightListMid = listMid.subList(mid+1,listMid.size());
        List rightListFirst = listFirst.subList(mid+1,listFirst.size());
        Node right = buildTreeBy(rightListFirst,rightListMid);
        root.left = left;
        root.right = right;
        return root;
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
