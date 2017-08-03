package chapter07.unit9;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.9.1 继承与初始化
 */
class Insect {
    private int i = 9;
    protected int j;
    private static int x1 = printInit("static Insect.x1 initialized");

    public Insect() {
        System.out.println("i: " + i + ", j: " + j);
        j = 49;
    }

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private static int k = printInit("static Beetle.k initialized");
    private static int x2 = printInit("static Beetle.x2 initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("x2 = " + x2);
    }

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle beetle = new Beetle();
    }
}
