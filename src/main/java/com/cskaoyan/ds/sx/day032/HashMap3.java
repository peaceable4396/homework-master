package com.cskaoyan.ds.sx.day032;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sx
 * @since 2022/05/19 22:02
 */

public class HashMap3 {
    public static void main(String[] args) {
        String s = "aababcabcdabcde";
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c1 : c) {
            if (map.containsKey(c1)){
                int count = map.get(c1);
                count++;
                map.remove(c1);
                map.put(c1,count);
            } else {
                map.put(c1,1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.print(entry.getKey() + "(" + entry.getValue() + ")");
        }
    }
}
