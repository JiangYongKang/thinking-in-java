package chapter.ten.unit.four;

/**
 * Author: vincent
 * Date: 2017-12-28 14:25:00
 * Comment: Think in Java 10.4 内部类与向上转型
 */
public class Parcel {

    // 私有内部类，除了外部类，没人可以访问他
    private class InnerContents implements Contents {
        private int i = 100;

        @Override
        public int value() {
            return i;
        }
    }

    // 受保护的内部类，只有外部类和外部类的子类，以及同一个包下的类可以访问
    protected class InnerDestination implements Destination {
        private String label;

        public InnerDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public InnerContents contents() {
        return new InnerContents();
    }

    public InnerDestination destination(String s) {
        return new InnerDestination(s);
    }
}
