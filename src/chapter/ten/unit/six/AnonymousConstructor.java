package chapter.ten.unit.six;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/10
 * Comment: Thinking in Java 10.6.2 匿名内部类
 */
abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }

    public abstract void f();
}

public class AnonymousConstructor {

    // 在匿名内部类使用外部定义的对象时，其参数引用必须是 final 的
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous -> f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(100);
        base.f();
    }
}
