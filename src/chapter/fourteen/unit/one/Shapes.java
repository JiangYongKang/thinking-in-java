package chapter.fourteen.unit.one;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/3
 * Comment: Thinking in Java 14.1.1 为什么需要 "RTTI" (Run Time Type Information)
 * Shape 接口中动态绑定了 draw() 方法，目的就是让子类使用泛型化的 Shape 引用来调用 draw() 方法。
 * draw() 在所有的派生类中都会被覆盖，并且由于它是被动态绑定的，所以即使是通过泛型化的 Shape 引用来调用，也能产生正确的行为。
 */
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        // 当将三个派生类对象放入 List<Shape> 集合中，会自动向上转型。
        // 但是在自动向上转型的同时也丢失了具体的类型，对于集合看来，他们都是 Shape 类型的。
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());

        // 当元素从集合中被拿出来时，他会将所有的元素都当做为 Object 类型，再转换为 Shape。
        // 这也是 RTTI 名字的含义：在运行时，识别一个对象。
        // 但是这个例子转换的并不彻底，因为他们都是被转换为 Shape，而不是 Circle、Square、Triangle
        for (Shape shape : shapes) {

            // 接下来执行就有多态机制去保证，shape 究竟执行什么样的代码。
            // 决定于引用所指向的具体对象 Circle、Square、Triangle 来决定
            shape.draw();
        }
    }
}
