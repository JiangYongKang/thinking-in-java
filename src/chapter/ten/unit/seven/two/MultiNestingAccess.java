package chapter.ten.unit.seven.two;

/**
 * Author: vincent
 * Date: 2017-12-28 16:31:00
 * Comment:  Think in Java 10.7.2 从多层嵌套类中访问外部类的成员
 */
class Outer {
    public void method() {
        System.out.println("outer x");
    }

    class InnerOne {
        public void method() {
            System.out.println("inner one method");
        }

        public class InnerTwo {
            public void method() {
                Outer.this.method();
                InnerOne.this.method();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        // 内部类嵌套多少层并不重要，.new 语法都能产生正确的作用域
        // 这种场景很少见，嵌套层级过多反而影响代码的整洁性
        Outer outer = new Outer();
        Outer.InnerOne innerOne = outer.new InnerOne();
        Outer.InnerOne.InnerTwo innerTwo = innerOne.new InnerTwo();

        outer.method();
        innerOne.method();
        innerTwo.method();
    }
}
