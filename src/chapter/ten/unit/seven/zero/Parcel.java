package chapter.ten.unit.seven.zero;

/**
 * Author: vincent
 * Date: 2017-12-28 16:00:00
 * Comment: Think in Java 10.7 嵌套类（静态内部类）
 */
public class Parcel {

    // 静态内部类不可以访问外部类的非静态成员变量
    private static class ParcelContents implements Contents {
        @Override
        public int value() {
            return 100;
        }
    }

    // 普通内部类在被创建的时候，隐式的持有一个外部类对象的引用，因此在普通内部类中可以使用 "外部类.this" 来指向外部类对象实例
    // 但是静态内部类并不会隐式持有外部类对象，因为它是静态的，会被预先加载到内存中
    // 所以在静态内部类中不可以使用 "外部类.this" 这种语法，也不可以调用外部类中非静态属性和成员变量
    protected static class ParcelDestination implements Destination {
        private String label;

        public ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static void f() {}

        static int x = 10;

        static class AnotherLevel {
            public static void f() {}
            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("Tasmania");
        System.out.println(contents.value());
        System.out.println(destination.readLabel());

        // 创建静态内部类对象并不需要先具备外部类对象实例
        ParcelContents contentsTwo = new Parcel.ParcelContents();
        System.out.println(contentsTwo.value());
    }
}
