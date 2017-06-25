package chapter7.unit2;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.2.1 初始化基类（带参数的构造器）
 * 如果没有默认的构造器，或者想使用一个带参数的构造器，就必须使用super()关键字显示的指定，否者编译器将报错
 */
class Game {
    public Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    public BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    public Chess(int i) {
        super(i);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess chess = new Chess(100);
    }
}
