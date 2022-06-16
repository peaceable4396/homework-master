package com.cskaoyan.ds.sx.day027;

import java.util.Objects;

/**
 * @author sx
 * @since 2022/05/14 14:00
 */

class ArrayList<T>{
    private static final int INIT_CAPACITY = 10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private Object[] object;
    private int size;

    public ArrayList() {
        this.object = new Object[INIT_CAPACITY];
    }
    public ArrayList(int initcapacity) {
        if (initcapacity < 0 || initcapacity > MAX_CAPACITY){
            throw new IllegalArgumentException("prama is Illegal");
        }
        this.object = new Object[initcapacity];
    }

    //增
    public boolean add(T t){
        if (size == object.length){
            int newLen = getNewLen();
            grow(newLen);
        }
        if (t == null){
            throw new IllegalArgumentException("data is Illegal");
        }
        object[size] = t;
        size++;
        return true;
    }
    //增
    public boolean add(T t, int index){
        if (isEmpty()){
            throw new IllegalArgumentException("list is empty");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("prama is Illegal");
        }
        if (t == null){
            throw new IllegalArgumentException("data is Illegal");
        }
        size++;
        for (int i = size; i > index; i--) {
            object[i] = object[i - 1];
        }
        object[index] = t;
        return true;
    }
    //删
    public T remove(int index){
        if (isEmpty()){
            throw new IllegalArgumentException("list is empty");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("prama is Illegal");
        }
        T temp = ((T) object[index]);
        for (int i = index; i < size; i++) {
            object[i] = object[i + 1];
        }
        size--;
        return temp;
    }
    //改
    public boolean set(T t ,int index){
        if (isEmpty()){
            throw new IllegalArgumentException("list is empty");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("prama is Illegal");
        }
        if (t == null){
            t = remove(index);
            return true;
        }
        object[index] = t;
        return true;
    }
    //查
    public T get(int index){
        if (isEmpty()){
            throw new IllegalArgumentException("list is empty");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("prama is Illegal");
        }
        return (T)object[index];
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int getNewLen(){
        int oldLen = object.length;
        int newLen = oldLen * 2;
        if (newLen < 0 || newLen > MAX_CAPACITY){
            newLen = MAX_CAPACITY;
        }
        if (newLen == oldLen){
            throw new StackOverflowError("stack is overflow");
        }
        return newLen;
    }
    public void grow(int newLen){
        Object[] obj = new Object[newLen];
        for (int i = 0; i < object.length; i++) {
            obj[i] = object[i];
        }
        object = obj;
    }
    public int getSize(){
        return size;
    }
}
