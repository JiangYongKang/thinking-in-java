package chapter.seven.unit.eight;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.7.0 final 参数
 * Java 允许在参数列表中以声明的方式将参数指明为 final，这意味着将无法在方法中更改参数所指向的对象
 */
class Gizmo {
    public void spin() {
    }
}

public class FinalArguments {
    public void with(final Gizmo gizmo) {
        // 无法在方法中 gizmo 所指向的对象，因为它是 final 的
        // gizmo = new Gizmo();
    }

    public void withOut(Gizmo gizmo) {
        gizmo = new Gizmo();
        gizmo.spin();
    }

    public static void main(String[] args) {
        FinalArguments finalArguments = new FinalArguments();
        finalArguments.with(null);
        finalArguments.withOut(null);
    }
}
