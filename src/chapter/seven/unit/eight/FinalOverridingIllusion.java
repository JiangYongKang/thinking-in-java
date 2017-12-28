package chapter.seven.unit.eight;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.8.2 final 方法
 * 把方法锁定，防止任何继承类修改它的含义。
 * 类中所有的 private 方法都隐式的指定为 final 的，由于导出类无法覆盖基类中 private 方法。
 * 将 private 方法修饰为 final 是可以的，但是没有任何意义。
 */
class WithFinals {
    private final void f() {
        System.out.println("WithFinals f()");
    }

    private void g() {
        System.out.println("WithFinals g()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.println("OverridingPrivate f()");
    }

    private void g() {
        System.out.println("OverridingPrivate g()");
    }
}

class OverridingPrivate2 extends WithFinals {
    public final void f() {
        System.out.println("OverridingPrivate2 f()");
    }

    public void g() {
        System.out.println("OverridingPrivate2 g()");
    }
}

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // OverridingPrivate op = op2;
        // op.f();
        // op.g();
        WithFinals wf = op2;
        // wf.f();
        // wf.g();
    }
}
