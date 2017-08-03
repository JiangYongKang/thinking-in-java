package chapter05.unit7;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/5/14
 * Comment: Thinking in Java 5.7.1 静态成员的初始化
 * 1. 静态成员变量的初始化要优先于成员变量，但是静态成员变量只有在必要的时候才会初始化。
 * 2. 如果不创建对象，或者不通过类名直接调用，静态成员永远也不会初始化。
 * 3. 静态成员变量只会初始化一次，就是在第一次创建对象时，后面无论创建多少次该对象，都不会再次初始化。
 * 4. 静态成员变量 ==> 成员变量 ==> 方法
 */
class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl class marker: " + marker);
    }

    void method(int marker) {
        System.out.println("Bowl method: " + marker);
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);

    Table() {
        System.out.println("Table class marker");
        bowl2.method(1);
    }

    void method(int marker) {
        System.out.println("Table method: " + marker);
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    // 静态成员变量的初始化优先于普通成员变量，因此该成员变量会在静态成员变量初始化完毕之后才会初始化
    Bowl bowl3 = new Bowl(3);
    //静态成员变量的初始化也是按从上到下按顺序执行，所以它是类中的第一个静态成员变量，最先初始化
    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        System.out.println("Cupboard class marker");
        bowl4.method(1);
    }

    void method(int marker) {
        System.out.println("Cupboard method: " + marker);
    }

    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard in main");
        new Cupboard();
        System.out.println("Creating new Cupboard in main");
        new Cupboard();
        table.method(1);
        cupboard.method(1);
    }
    // 成员变量初始化优先于方法，所以该行代码会优先于 main 方法的执行
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
