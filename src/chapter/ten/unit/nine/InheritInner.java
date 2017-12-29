package chapter.ten.unit.nine;

/**
 * Author: vincent
 * Date: 2017-12-29 14:08:00
 * Comment: Think in Java 10.9 内部类的继承
 * 因为内部类的构造器必须链接到外部类对象的引用，所以再继承内部类的时候，会比较复杂
 * 问题是：内部类隐式的指向外部类的引用必须被初始化，而在子类中并不存在可链接的默认对象
 * 所以，继承内部类的语法形式如下。
 */
public class InheritInner extends Outer.Inner {
    public InheritInner(Outer outer) {
        // 必须在构造器内向父类（也就是内部类）传递一个外部类的引用
        outer.super();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(new InheritInner(outer));
    }
}
