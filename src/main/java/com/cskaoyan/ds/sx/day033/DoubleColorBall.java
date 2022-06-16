package com.cskaoyan.ds.sx.day033;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

/**
 * 1,双色球规则：
 * 双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
 * 红色球号码从1—33中选择；蓝色球号码从1—16中选择；
 * 请随机生成一注双色球号码。
 *
 * @author sx
 * @since 2022/05/22 22:15
 */

public class DoubleColorBall {
    public static void main(String[] args) {
        HashSet<Ball> balls = new HashSet<>();
        balls.add(new Ball("red"));
        balls.add(new Ball("red"));
        balls.add(new Ball("red"));
        balls.add(new Ball("red"));
        balls.add(new Ball("red"));
        balls.add(new Ball("red"));
        balls.add(new Ball("blue"));
        Iterator<Ball> iterator = balls.iterator();
        while (iterator.hasNext()) {
            Ball next =  iterator.next();
            System.out.println(next);
        }
    }
}

class Ball {
    private String color;
    private int num;
    static Random random = new Random();

    public Ball(String color) {
        this.color = color;
        if ("red".equals(this.color)) {
            this.num = random.nextInt(33) + 1;
        }
        if ("blue".equals(this.color)) {
            this.num = random.nextInt(16) + 1;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return num == ball.num && Objects.equals(color, ball.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, num);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color='" + color + '\'' +
                ", num=" + num +
                '}';
    }
}
