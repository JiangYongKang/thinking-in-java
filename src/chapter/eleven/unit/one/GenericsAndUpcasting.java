package chapter.eleven.unit.one;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment: Thinking in Java 11.1.0 泛型和类型安全的容器
 * 1. 向上转型可以像作用于其他类型一样作用于泛型
 */
class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class GrannySmith extends Apple {}
class Gala extends Apple {}
class Fuji extends Apple {}
class Braeburn extends Apple {}

public class GenericsAndUpcasting {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple apple : apples) {
            System.out.println(apple.id());
        }


    }
}
