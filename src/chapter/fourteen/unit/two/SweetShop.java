package chapter.fourteen.unit.two;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/3
 * Comment: Thinking in Java 14.2.0 Class 对象
 * Class 对象仅仅在需要的时候才会被加载，static 初始化是在类被加载时候进行的
 */

class Candy {
    static {
        System.out.println("Loading Candy ... ");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum ... ");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie ... ");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main ... ");
        new Candy();
        System.out.println("After creating Candy");
        try {
            // forName 是取得 Class 对象引用的一种方法。
            // 用一个包含目标类的文本名的 String 作为输入参数，返回的是一个 Class 对象引用。
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
