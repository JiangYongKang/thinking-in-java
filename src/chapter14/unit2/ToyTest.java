package chapter14.unit2;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/8/3
 * Comment: Thinking in Java 14.2.0 Class 对象
 * Class 对象仅仅在需要的时候才会被加载，static 初始化是在类被加载时候进行的
 */
interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    public Toy() {
    }

    public Toy(int i) {
    }
}


class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class<?> cc) {
        // 包名 + 类名
        System.out.println("Class name: " + cc.getName());
        // 是否属于接口
        System.out.println("Is interface? " + cc.isInterface());
        // 类名
        System.out.println("Simple name: " + cc.getSimpleName());
        // 包名 + 类名
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            // 通过类的全路径加载类
            c = Class.forName("chapter14.unit2.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy.");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        // 获取父类的对象信息
        Class<?> up = c.getSuperclass();
        Object object = null;
        try {

            // 调用默认构造器
            object = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate.");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access.");
            System.exit(1);
        }
        printInfo(object.getClass());
    }
}
