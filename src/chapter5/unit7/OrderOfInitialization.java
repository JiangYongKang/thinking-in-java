package chapter5.unit7;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/5/14
 * Comment: Thinking in Java 5.7.1 初始化顺序
 * 1. 类的初始化会先初始化成员变量，再初始化方法，包括构造方法。
 */
class Window {
    Window(int marker) {
        System.out.println("Window: " + marker);
    }
}

class House {
    Window w1 = new Window(1);

    House() {
        System.out.println("init house");
        w3 = new Window(4);
    }

    Window w2 = new Window(2);
    Window w3 = new Window(3);
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House hourse = new House();
    }
}
