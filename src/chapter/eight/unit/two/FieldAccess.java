package chapter.eight.unit.two;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/4
 * Comment: Thinking in Java 8.2.5 缺陷：域与静态方法
 * 只有普通的方法调用时多态的，属性是不会多态的。
 */
class Super {
    public int field = 100;

    public int getField() {
        return field;
    }
}

/**
 * 在基类和导出类中都有一个 field 属性。
 * 当导出类被实例化时，将会有两个不同域的 field，一个属于导出类本身的 field，一个属于基类的 field。
 * 导出类的方法可以去覆盖基类的方法，但是导出类的属性绝对不会覆盖基类的属性
 */
class Sub extends Super {
    public int field = 200;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        // 虽然 sup 经过自动向上转型，转变为了 Sub 对象引用。但是域（属性）是不会进行多态的，也就是说，导出类 Sub 含有两个域的 field，
        // 一个是自己的 field，一个是基类的 field。此处输出的是基类的 field 的值。
        System.out.println("sup.field = " + sup.field + ", sup -> getField() = " + sup.getField() + "");
        // output: sup.field = 100, sup -> getField() = 200

        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + ", sub -> getField() = " + sub.getField() + ", sub -> getSuperField() = " + sub.getSuperField());
        // output: sub.field = 200, sub -> getField() = 200, sub -> getSuperField() = 100
    }
}
