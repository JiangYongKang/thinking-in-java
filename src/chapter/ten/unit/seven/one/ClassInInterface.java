package chapter.ten.unit.seven.one;

/**
 * Author: vincent
 * Date: 2017-12-28 16:20:00
 * Comment: Think in Java 10.7.1 接口的内部类
 */
public interface ClassInInterface {
    void howdy();

    /**
     * 一般情况下，接口中只能有抽象方法，但是，内部类可以作为接口中的一部分，只是将内部类置于接口的命名空间之下
     * 放在接口中的类默认是 public static 的，甚至可以用接口中的内部类来实现接口
     * 这种写法的应用场景是，可以为接口的某个抽象方法提供默认的实现，供其他类使用
     */
    class Inner implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("inner howdy");
        }

        public static void main(String[] args) {
            new Inner().howdy();
        }
    }
}
