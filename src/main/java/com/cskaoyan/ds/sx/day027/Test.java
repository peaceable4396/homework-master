package com.cskaoyan.ds.sx.day027;

/**
 * @author sx
 * @since 2022/05/14 14:36
 */

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("test",0);
        list.add("test",1);
        list.add("test",3);
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("ff");

        System.out.println(list.getSize());
        System.out.println(list.get(8));
        list.set("aa",3);
        //null视为删除
        list.set(null,3);
        System.out.println(list.getSize());
        System.out.println(list);
    }
}
