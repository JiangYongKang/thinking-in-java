package chapter.seven.unit.eight;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.8.1 空白 final
 * 编译器允许生成空白的 final， 即未初始化的 final 数据、方法、类。
 * 但是在其使用前必须被初始化
 */
class Poppet {
    private int i;

    public Poppet(int i) {
        this.i = i;
    }
}

public class BlankFinal {
    private final int i = 0;
    // 此处可以不初始化，但是在构造器中必须为其初始化，否则编译不通过
    private final int j;
    private final Poppet poppet;

    public BlankFinal() {
        j = 1;
        poppet = new Poppet(1);
    }

    public BlankFinal(int x) {
        this.j = x;
        this.poppet = new Poppet(x);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(100);
    }
}
