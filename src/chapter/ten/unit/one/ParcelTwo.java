package chapter.ten.unit.one;

/**
 * Author: vincent
 * Date: 2017-12-28 10:45:00
 * Comment: Think in Java 10.1 创建内部类
 */
public class ParcelTwo {
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

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents contents = contents();
        Destination destination = to(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        ParcelTwo parcelTwo = new ParcelTwo();
        parcelTwo.contents();
        parcelTwo.ship("Tasmania");
        ParcelTwo.Contents contents = parcelTwo.contents();
        ParcelTwo.Destination destination = parcelTwo.to("Borneo");
    }
}
