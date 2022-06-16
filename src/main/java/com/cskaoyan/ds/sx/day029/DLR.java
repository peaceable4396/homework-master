package com.cskaoyan.ds.sx.day029;

import java.util.LinkedList;

/**
 * @author sx
 * @since 2022/05/16 18:54
 */

public class DLR {
    public static void main(String[] args) {
        MyBSTree<Integer> tree = new MyBSTree<>();
        LinkedList<Integer> listFirst = new LinkedList<>();
        listFirst.add(10);
        listFirst.add(1);
        listFirst.add(-10);
        listFirst.add(5);
        listFirst.add(2);
        listFirst.add(3);
        listFirst.add(6);
        listFirst.add(9);
        listFirst.add(40);
        listFirst.add(20);
        listFirst.add(30);
        listFirst.add(80);
        listFirst.add(60);
        listFirst.add(100);
        listFirst.add(90);


        LinkedList<Integer> listMid = new LinkedList<>();
        listMid.add(-10);
        listMid.add(1);
        listMid.add(2);
        listMid.add(3);
        listMid.add(5);
        listMid.add(6);
        listMid.add(9);
        listMid.add(10);
        listMid.add(20);
        listMid.add(30);
        listMid.add(40);
        listMid.add(60);
        listMid.add(80);
        listMid.add(90);
        listMid.add(100);

        tree.build(listFirst,listMid);
        System.out.println(tree);

    }
}
