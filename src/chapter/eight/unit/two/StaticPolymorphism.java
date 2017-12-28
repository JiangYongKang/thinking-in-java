package chapter.eight.unit.two;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/4
 * Comment: Thinking in Java 8.2.5 缺陷：域与静态方法
 * 静态方法是与类关联绑定的，并非与某个对象进行绑定。
 * 换个角度想，静态方法会被预先加载到内存中，那么静态方法有怎么可能被多态？
 */
class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    // @Override 编译器不允许重写基类的静态方法
    // 也就意味着，假如某个方法是静态方法，那么这个方法就不再具备多态性
    public static String staticGet() {
        return "Derived staticGet()";
    }

    @Override
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper staticSuper = new StaticSub();
        System.out.println(staticSuper.staticGet()); // 静态方法通常用 ClassName.MethodName() 调用
        System.out.println(staticSuper.dynamicGet());
    }
}
