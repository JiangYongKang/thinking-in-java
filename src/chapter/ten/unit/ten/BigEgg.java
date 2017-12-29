package chapter.ten.unit.ten;

/**
 * Author: vincent
 * Date: 2017-12-29 14:18:00
 * Comment: Thinking in Java 10.10 内部类可以被覆盖吗
 * 默认的构造器是编译器自动生成的，这里是调用子类的默认构造方法
 * 当继承了某个外部类的时候，内部类并没有产生什么神奇的变化，这两个内部类是完全独立的两个实体
 * 他们在各自的命名空间中
 */
class Egg {
    private Yolk yolk;

    public Egg() {
        System.out.println("New Egg()");
        this.yolk = new Yolk();
    }

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk");
        }
    }
}

public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
