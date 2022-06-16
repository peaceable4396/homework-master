package com.cskaoyan.ds.sx.day034;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1, 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
 * // [1,2,3,4,5] -> [1,4,9,16,25]
 * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 * @author sx
 * @since 2022/05/22 22:43
 */

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream()
                .map(a -> a * a)
                .collect(Collectors.toList()));
    }
}
