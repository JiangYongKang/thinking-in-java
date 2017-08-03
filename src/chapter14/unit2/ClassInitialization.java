package chapter14.unit2;

import java.util.Random;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/3
 * Comment: Thinking in Java 14.2.1 类字面常量
 * Java 提供了另一种方法来生成对 Class 对象的引用，即 "类字面常量"，如：String.class
 * 1. 编译时就得到检查，不必置于 try catch 块中。
 * 2. 根除了 forName() 的调用，更高效
 * 3. 采用 .class 的方法不会引发类的初始化，而采用 forName() 就会引发。
 */

class Initable {
    // 如果一个值是 static final (编译时常量) 的，那么这个值不需要对该类进行初始化就可以读取
    static final int STATIC_FINAL = 47;

    // 但是如果只是将一个域设置为 static final 的，还不足以确保不被初始化，如下面这行代码就会触发类的初始化
    // 因为他不是一个编译时常量，他的值室友表达式计算得来
    static final int STATIC_FINAL_2 = ClassInitialization.random.nextInt(100);

    static {
        System.out.println("Initialization Initable");
    }
}

class Initable2 {
    // 如果一个 static 的域不是 final 的。
    // 那么对他访问时，总是要求再被读取之前进行链接（为这个域分配空间）和初始化（初始化该存储空间）
    static int STATIC_NON_FINAL = 147;

    static {
        System.out.println("Initialization Initable2");
    }
}

class Initable3 {
    static int STATIC_NON_FINAL = 74;

    static {
        System.out.println("Initialization Initable3");
    }
}

public class ClassInitialization {
    public static Random random = new Random(47);

    public static void main(String[] args) {
        Class<Initable> initableClass = Initable.class;
        System.out.println("After creating Initable ref.");
        System.out.println("Initable.STATIC_FINAL");
        System.out.println("Initable.STATIC_FINAL_2");
        System.out.println("Initable2.STATIC_NON_FINAL");
        Class<Initable3> initable3Class = Initable3.class;
        System.out.println("After creating Initable3 ref.");
        System.out.println("Initable3.STATIC_NON_FINAL");
    }
}
