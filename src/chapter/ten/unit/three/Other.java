package chapter.ten.unit.three;

/**
 * Author: vincent
 * Date: 2017-12-28 13:56:00
 * Comment: Think in Java 使用.this 和 .new 练习题
 */
public class Other {
    public static void main(String[] args) {
        // 一个外部类的对象
        Outer outer = new Outer();
        // 试图创建一个非静态内部类对象，必须先创建一个外部类对象，然后通过 "外部类对象.new" 来创建内部类对象
        // 因为内部类对象会隐式的链接到外部类对象中
        // 也正是因为内部类对象会自动链接到外部类对象，所以内部类对象才可以毫无限制的访问外部类的方法和属性
        Outer.Inner inner = outer.new Inner();
        // 创建静态内部类对象，并不需要先创建外部类对象
        // 因为静态方法是属于类的，它遵循静态的特性，一样会被预先加载到内存中
        // 这也是为什么内部类可以访问外部类的成员属性和方法，而静态内部类却只可以访问外部类的静态成员属性和方法
        // 另外，静态内部类并不会隐式的链接到外部类对象。因为静态内部类是被预先加载到内存中的，而那时外部类对象并未创建
        Outer.StaticInner staticInner = new Outer.StaticInner();
    }
}
