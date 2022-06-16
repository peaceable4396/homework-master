package com.cskaoyan.ds.sx.day032;

import java.util.*;

/**
 * 如果存在一个Collection中存储了多个User对象,其中有一些User数据是重复的. 获得一个包含不重复User的Collection集合
 * @author sx
 * @since 2022/05/19 20:19
 */

public class HashMap {
    public static void main(String[] args) {
        User user1 = new User("zs",18);
        User user2 = new User("zs",18);
        User user3 = new User("ls",18);
        User user4 = new User("wu",18);
        User user5 = new User("zl",18);
        User user6 = new User("zl",18);
        User user7 = new User("zs",19);
        User user8 = new User("zs",20);
        List<User> users = new LinkedList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        java.util.HashMap<String,Integer> map = new java.util.HashMap<>();
        ListIterator<User> iterator = users.listIterator();
        while (iterator.hasNext()){
            User userTemp = iterator.next();
            if (map.containsKey(userTemp.getName())){
                if (map.get(userTemp.getName()) == userTemp.getAge()){
                    iterator.remove();
                }
            }
            map.put(userTemp.getName(),userTemp.getAge());
        }
        for (User user : users) {
            System.out.println(user);
        }
    }
}
class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.age == ((User) obj).age && this.name.equals(((User) obj).getName()));
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
