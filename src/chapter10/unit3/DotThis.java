package chapter10.unit3;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/10
 * Comment: Thinking in Java 10.3.1 使用 ".this"
 */
public class DotThis {
    public void f() {
        System.out.println("DotThis -> f()");
    }

    // 内部类
    // 如果要在内部类中生成对外部类的引用，可以使用 "外部类.this"
    // 这种方法在编译时就被知晓，因此没有任何运行时的开销
    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();

        DotThis.Inner inner1 = dotThis.inner();

        // 使用 "外部类对象.new" 也可以创建内部类对象，但是需要注意的是：除非内部类是静态的，否则创建内部类的对象必须存在一个外部类的对象
        DotThis.Inner inner2 = dotThis.new Inner();

        inner1.outer().f();
        inner2.outer().f();
    }
}
