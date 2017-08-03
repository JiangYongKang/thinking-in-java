package chapter08.unit2;

import java.util.Random;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/4
 * Comment: Thinking in Java 8.2.2 产生正确的行为（动态绑定）
 * 将一个方法调用同一个方法主体关联起来称作为绑定
 * 程序执行前绑定叫做前期绑定，运行时根据对象的类型进行绑定称为后期绑定（动态绑定）
 * Java 中除了 final 和 private 之外，所有的方法都是通过动态绑定来实现多态
 * 我们不必判断是否应该后期绑定，因为它是自动发生的
 */
class Shape {
    public void draw() {
        System.out.println("Shapes -> draw()");
    }

    public void erase() {
        System.out.println("Shapes -> erase()");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle -> draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle -> erase()");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square -> draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square -> erase()");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle -> draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle -> erase()");
    }
}

class RandomShapeGenerator {
    private Random random = new Random(47);

    public Shape next() {
        switch (random.nextInt(3)) {
            case 1:
                return new Circle();
            case 2:
                return new Square();
            case 3:
                return new Triangle();
            default:
                return new Shape();
        }
    }
}

public class Shapes {

    // 工厂类，每次调用它的 next() 方法，便会水机产生一个 Shapes 的之类
    private static RandomShapeGenerator randomShapeGenerator = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        /*
          向上转型可以是一条非常简单的语句，例如：
          Shapes shape = new Circle();
          这里看似错误，将一种类型赋值给了另一种类型，实际上他是正确的。
          从面像对象的角度来考虑，导出类与基类是同一种类型，导出类具备基类的全部方法与特性。
          通过继承 Circle 就是一种 Shapes，因此编译器认可这条语句，也不会给出错误信息。

          假设这时我们调用对象方法，例如：
          shape.draw();
          我们可能再次认为我们调用的是 Shapes -> draw()，因为这毕竟声明的是一个 Shapes 引用
          但是由于 Java 后期绑定是自动进行的，我们没做任何干预，编译器实际上调用的是 Circle -> draw()
         */
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = randomShapeGenerator.next();
        }
        for (Shape shape : shapes) {
            shape.draw();
        }
        for (Shape shape : shapes) {
            shape.erase();
        }
    }
}
