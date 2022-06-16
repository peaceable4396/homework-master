package com.cskaoyan.ds.sx.day026;

import java.util.Objects;

/**
 * @author sx
 * @since 2022/05/13 09:43
 */

public class Demo1 {
    public static void main(String[] args) {
        MyDBLinkedList<String> list = new MyDBLinkedList<>();

        System.out.println(list.contains("aa"));
        System.out.println(list.set("aa", "bb"));
        // System.out.println(list.get(6)); 报错
        // System.out.println(list.set(5, "aa")); 报错

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add(null);
        list.add("ff");
        list.add("gg");

        System.out.println(list.contains("aa"));
        System.out.println(list.set("aa", "bb"));
        System.out.println(list.get(6));
        System.out.println(list.set(5, "aa"));

    }
}
class MyDBLinkedList<T>{

    private Node head; // 双向链表的头结点
    private Node end; // 双向链表的尾结点
    private int size; // 存储了多少元素

    /**
     * MyDBLinkedList的添加方法
     * @param str : 把str添加到底层的双向链表上
     * @return : 添加是否成功
     */
    public boolean add(T str){
        // 判断链表是否为空
        if (isEmpty()){
            // 如果原链表为空 --> 添加的结点既是头结点, 又是尾结点
            head = new Node(str);
            end = head;
            size++;
            return true;
        }

        // 走到这: 意味着原链表至少有一个结点

        // 因为没有指明添加位置: 添加到尾部
        // 核心逻辑:  首先创建结点
        //           和原本的尾结点构建双向链接
        //           尾标记后移

        Node node = new Node(str);
        end.next = node;
        node.pre = end;
        end = end.next;

        size++;

        return true;
    }

    /**
     * MyDBLinkedList 根据指定值的删除方法
     * @param str : 要删除的内容
     * @return : 删除是否成功
     */
    public boolean remove(T str){
        // 判断链表是否为空
        if (isEmpty()){
            throw new RuntimeException("linked is empty");
        }

        // 根据内容删除: 我们是不确定这个内容存储在链表那个位置
        // 存储在头: 删除头: 头标记后移
        // 存储在尾: 删除尾: 尾标记前移
        // 删除中间结点:  先找到要删除的中间结点, 中间结点的前后结点相互指向

        // 判断删除的是不是头结点
        if (Objects.equals(str,  head.value)){
            // 要删除的是头结点
            // 判断: 链表中是否只剩一个结点
            if (size == 1){
                // 头尾清空
                head = null;
                end = null;
            }else {
                // 删除的是头结点, 而且链表中有多个结点  --> 头标记后移
                head = head.next;
                head.pre = null;
            }
            size--;
            return true;
        }


        // 判断删除的是否是尾结点
        if (Objects.equals(str,  end.value)){
            end = end.pre;// 前移一个结点
            end.next = null; // 和原本的尾断开连接
            size--;
            return true;
        }

        // 删除中间的某个结点
        Node mid = head;

        // 遍历结点的下一个结点存在, 并且下一个结点也不是我们要查找的内容 ---> 向后遍历
        while (mid.next != null && !Objects.equals(mid.next.value, str)){
            mid = mid.next;
        }


        // 上述循环: 有两个跳出条件
        if (mid.next == null){
            // 这个链表中没有存储这个内容
            return false;
        }

        // 找到了,  要删除的是mid.next
        Node removeNode = mid.next;

        removeNode.pre.next = removeNode.next;
        removeNode.next.pre = removeNode.pre;
        size--;

        return true;
    }

    /**
     * MyDBLinkedList 根据内容的查找方法
     * @param str : 在链表中要查找的内容
     * @return : 是否存在在链表上
     */
    public boolean contains(T str){
        if (isEmpty()){
            return false;
        }
        Node head1 = head;
        Node end1 = end;
        for (int i = 0; i < size / 2; i++) {
            if (Objects.equals(str,head1.value) || Objects.equals(str,end1.value)){
                return true;
            }
            head1 = head1.next;
            end1 = end1.pre;
        }
        return false;
    }

    /**
     * MyDBLinkedList的替换方法
     * @param oldValue : 要被替换的旧值
     * @param newValue : 用来替换的新值
     * @return : 替换是否成功
     */
    public boolean set(T oldValue, T newValue){
        if (isEmpty()){
            return false;
        }
        Node head1 = head;
        Node end1 = end;
        for (int i = 0; i < size / 2; i++) {
            if (Objects.equals(oldValue,head1.value)){
                head1.value = newValue;
                return true;
            }else if (Objects.equals(oldValue,end1.value)){
                end1.value = newValue;
                return true;
            }
            head1 = head1.next;
            end1 = end1.pre;
        }
        return false;
    }


    /**
     * 根据下标的添加方法
     * @param index : 要添加的下标位置
     * @param str : 添加的内容
     * @return : 添加是否成功
     */
    public boolean add(int index, T str){
        // 下标是否合法: index  0 - size
        if (index < 0 || index > size){
            throw new IllegalArgumentException("parame is Illegal");
        }

        // 核心逻辑:
        //  添加到头位置
        //  添加到尾位置
        //  添加到中间某个位置:  看添加位置是偏头还是偏尾--> 决定查找添加位置的时候, 从前向后/从后向前


        // 判断添加的是否是头位置
        if (index == 0){
            // 添加的是头位置
            // 先判断链表是否为空
            if (isEmpty()){
                head = new Node(str);
                end = head;
            }else {
                // 原链表不空
                // 创建一个结点
                Node node = new Node(str);
                // 和头结点建立双向指向
                node.next = head;
                head.pre = node;
                // 头结点前移
                head = head.pre;
            }

            size++;
            return true;
        }

        // 添加的是尾
        if (index == size){
            return add(str);
        }

        // 添加到中间某个位置: 看添加位置是偏头还是偏尾--> 决定查找添加位置的时候, 从前向后/从后向前
        Node mid = head;
        if (index < size/2){
            // 偏头的位置

            int tag = 1;
            while (tag != index){
                mid =  mid.next;
                tag++;
            }
            // mid: 要添加之前的一个位置

        }else {
            // 偏尾的位置
            mid = end;
            int tag = size;
            while (tag != index){
                mid = mid.pre;
                tag--;
            }
            // mid:要添加之前的一个位置
        }


        // 一直mid就是要添加位置之前的位置

        Node node = new Node(str);
        node.next = mid.next;
        mid.next = node;
        node.next.pre = node;
        node.pre = mid;

//        Node node = new Node(str, mid, mid.next);
//        node.next.pre = node;
//        mid.next = node;

        size++;

        return true;
    }

    /**
     * 根据下标的删除方法
     * @param index: 要删除的下标位置
     * @return : 被删除下标位置存储的内容
     */
    public T remove(int index){
        // 下标是否合法: index  0 - size-1
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("parame is Illegal");
        }


        // 核心逻辑:
        // 删除头: 头后移
        // 删除尾: 尾前移
        // 中间某个结点:  先查找(偏头还是偏尾), 再删除

        // 判断删除的是否是头位置
        if (index == 0){
            // 判断整个链表是否只剩一个结点
            T oldValue = head.value;
            if (size == 1){
                // 如果链表中仅剩一个结点
                head = null;
                end = null;
            }else {
                // 链表中有多个结点
                head = head.next;
                head.pre = null;
            }
            size--;
            return oldValue;
        }

        // 判断删除的是否是尾结点
        if (index == size-1){
            T oldValue = end.value;
            end = end.pre;
            end.next = null;
            size--;
            return oldValue;
        }

        // 删除中间某个结点:
        Node mid = head;
        if (index < size/2){
            // 偏头的位置

            int tag = 1;
            while (tag != index){
                mid =  mid.next;
                tag++;
            }
            // mid: 要删除位置的之前一个结点

        }else {
            // 偏尾的位置
            mid = end;
            int tag = size;
            while (tag != index){
                mid = mid.pre;
                tag--;
            }
            // mid:要删除位置的之前一个结点
        }

        // mid: 要删除位置的之前一个结点
        Node removeNode = mid.next;

        // 让删除结点前后结点相互指向
        removeNode.next.pre = removeNode.pre;
        removeNode.pre.next = removeNode.next;

        size--;

        return removeNode.value;
    }

    /**
     * 根据下标的查找方法
     * @param index : 要查找的下标位置
     * @return : 对应下标位置存储的内容
     */
    public T get(int index){
        if (isEmpty()){
            throw new IllegalArgumentException("linkedlist is empty");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("parame is Illegal");
        }
        Node temp = head;
        if (index < size/2){
            int tag = 0;
            while (tag != index){
                temp =  temp.next;
                tag++;
            }
        }else {
            temp = end;
            int tag = size-1;
            while (tag != index) {
                temp = temp.pre;
                tag--;
            }
        }
        return temp.value;
    }

    /**
     * 根据下标的修改方法
     * @param index : 要修改的下标位置
     * @param newValue: 用替换的新值
     * @return : 被替换的旧值
     */
    public T set(int index, T newValue){
        if (isEmpty()){
            throw new IllegalArgumentException("linkedlist is empty");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("parame is Illegal");
        }
        Node temp = head;
        if (index < size/2){
            int tag = 0;
            while (tag != index){
                temp =  temp.next;
                tag++;
            }
        }else {
            temp = end;
            int tag = size-1;
            while (tag != index) {
                temp = temp.pre;
                tag--;
            }
        }
        T tempValue = temp.value;
        temp.value = newValue;
        return tempValue;
    }



    public boolean isEmpty() {
        return size == 0;
    }
    public int size(){
        return size;
    }

    class Node{
        T value; // 值域
        Node pre; // 前指针域
        Node next; // 后指针域

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
}
