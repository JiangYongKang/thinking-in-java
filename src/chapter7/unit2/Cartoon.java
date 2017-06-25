package chapter7.unit2;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.2.1 初始化基类（默认构造器）
 * 构建过程是从“基类”向外扩散的，所以基类在导出类的构造器访问它之前，就已经完场的初始化。
 * 根据打印结果，可以很明显的看出基类与导出类之间的初始化顺序
 */
class Art {
    public Art() {
        System.out.println("art constructor");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("drawing constructor");
    }
}

public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("cartoon constructor");
    }
    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
