package chapter.ten.unit.one;

/**
 * Author: vincent
 * Date: 2017-12-28 10:37:00
 * Comment: Think in Java 10.1 创建内部类
 */
public class Parcel {
    // 内部类 Contents
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    // 内部类 Destination
    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    // 这是外部类的方法，我们在外部类中的方法中使用内部类，与使用普通的类没有什么区别
    public void ship(String dest) {
        Contents contents = new Contents();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        parcel.ship("Tasmania");
    }
}
