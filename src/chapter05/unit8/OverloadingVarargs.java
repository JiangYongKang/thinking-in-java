package chapter05.unit8;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/5/14
 * Comment:
 */
public class OverloadingVarargs {
    static void method(String... args) {
        System.out.println("string array");
        for (int i = 0; i < args.length; i++) {
            System.out.print("args[" + i + "]: " + args[i]);
        }
        System.out.println();
    }

    static void method(Integer... args) {
        System.out.println("integer array");
        for (int i = 0; i < args.length; i++) {
            System.out.print("args[" + i + "]: " + args[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        method("1", "1");
        method(1, 1);

        // 可变参数是可以不传值的，但在此处重载了method方法。
        // 也就意味着，假如不传值，编译器也不知道我们想要调用哪个方法。
        //method();
    }
}
