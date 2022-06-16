package com.cskaoyan.ds.sx.day034;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 2, 基于提供的三个参考类型: 实现
 * // 找出2011年发生的交易记录, 按照从低到高交易额排序
 * // 找出交易员都在哪些不同的城市工作过的城市
 * // 查找来自北京的交易, 按交易员姓名排序
 * // 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
 * // 判断有没有交易员在北京工作
 * // 打印所有发生在北京的交易记录金额
 * // 所有交易中最高的交易是多少
 * // 所有交易中, 交易最低的交易信息
 *
 * @author sx
 * @since 2022/05/22 22:53
 */

public class StreamPractice2 {
    public static void main(String[] args) {
        System.out.println(TransactionRecord.transactions.stream()
                .filter(y -> y.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList()));
        System.out.println(TransactionRecord.transactions.stream()
                .map(c -> c.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList()));
        System.out.println(TransactionRecord.transactions.stream()
                .filter(c -> "beijing".equals(c.getTrader().getCity()))
                .sorted(Comparator.comparing((Transaction t) -> t.getTrader().getName()))
                .collect(Collectors.toList()));
        String s = TransactionRecord.transactions.stream()
                .map(name -> name.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList()).toString();
        System.out.println(s);
        System.out.println(TransactionRecord.transactions.stream()
                .anyMatch(a -> "beijing".equals(a.getTrader().getCity())));
        System.out.println(TransactionRecord.transactions.stream()
                .filter(a -> "beijing".equals(a.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList()));
        System.out.println(TransactionRecord.transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .map(Transaction::getValue)
                .limit(1)
                .collect(Collectors.toList()));
        System.out.println(TransactionRecord.transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .limit(1)
                .collect(Collectors.toList()));
    }
}
