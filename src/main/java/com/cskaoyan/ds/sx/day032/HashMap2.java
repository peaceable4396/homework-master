package com.cskaoyan.ds.sx.day032;

import java.util.HashMap;

/**
 * @author sx
 * @since 2022/05/19 21:56
 */

public class HashMap2 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,8,7,4,3};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = 9 - nums[i];
            if (map.containsKey(temp)){
                System.out.println("[" + i + "," + map.get(temp) + "]");
            }
            map.remove(nums[i]);
        }
    }
}
