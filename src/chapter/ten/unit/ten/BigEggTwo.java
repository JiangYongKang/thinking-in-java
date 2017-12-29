package chapter.ten.unit.ten;

/**
 * Author: vincent
 * Date: 2017-12-29 14:25:00
 * Comment: Thinking in Java 10.10 内部类可以被覆盖吗
 */
class EggTwo {
    private Yolk yolk = new Yolk();

    public EggTwo() {
        System.out.println("new EggTwo");
    }

    public void insertYolk(Yolk yolk) {
        this.yolk = yolk;
    }

    public void method() {
        yolk.method();
    }

    protected class Yolk {
        public Yolk() {
            System.out.println("EggTwo.Yolk");
        }

        public void method() {
            System.out.println("EggTwo.Yolk.method()");
        }
    }
}

public class BigEggTwo extends EggTwo {
    public BigEggTwo() {
        /**
         * BigEggTwo 中的内部类 Yolk 可以自动向上转型为 EggTwo 中的内部类 Yolk
         */
        insertYolk(new Yolk());
    }

    /**
     * 继承内部类
     */
    public class Yolk extends EggTwo.Yolk {
        public Yolk() {
            System.out.println("BigEggTwo.Yolk");
        }

        @Override
        public void method() {
            System.out.println("BigEggTwo.Yolk.method()");
        }
    }

    public static void main(String[] args) {
        EggTwo two = new EggTwo();
        two.method();
    }
}
