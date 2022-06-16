package com.cskaoyan.ds.sx.day030;

import com.cskaoyan.ds.sx.day030.MyBSTree;

/**
 * @author sx
 * @since 2022/05/17 18:48
 */

public class IsBSTree {
    public static void main(String[] args) {
        MyBSTree<Integer> tree1 = new MyBSTree<>();
        tree1.add(10);
        tree1.add(1);
        tree1.add(-10);
        tree1.add(5);
        tree1.add(2);
        tree1.add(3);
        tree1.add(6);
        tree1.add(9);
        tree1.add(40);
        tree1.add(20);
        tree1.add(30);
        tree1.add(80);
        tree1.add(60);
        tree1.add(100);
        tree1.add(90);
        System.out.println(tree1.isBST(tree1.root));
        tree1.replace(-20);
        System.out.println(tree1.isBST(tree1.root));
    }
}
