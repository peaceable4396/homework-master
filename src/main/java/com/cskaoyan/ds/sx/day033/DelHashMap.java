package com.cskaoyan.ds.sx.day033;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  已知HashMap存储了一批数据 HashMap<String, Integer>; 删除这批数据key-value中value为7或者8或者9的数据
 * @author sx
 * @since 2022/05/22 22:29
 */

public class DelHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aa",1);
        map.put("bb",2);
        map.put("cc",3);
        map.put("dd",7);
        map.put(null,8);
        map.put("ee",9);
        map.put("ff",4);
        map.put("gg",5);
        map.put("hh",6);
        map.put("jj",0);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next =  iterator.next();
            if (next.getValue() == 7 ||next.getValue() == 8 ||next.getValue() == 9){
                iterator.remove();
            }
        }
        System.out.println(map);
    }
}
