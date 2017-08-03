package chapter05.unit7;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/5/14
 * Comment: Thinking in Java 5.7.3 显式的静态初始化
 */
class Cup {
    Cup(int marker) {
        System.out.println("Cup class marker: " + marker);
    }
    void method(int marker){
        System.out.println("Cup method: " + marker);
    }
}
class Cups {
    static Cup cup1;
    static Cup cup2;

    // 静态代码块初始化的优先级要高于静态变量，只要对该类发送了消息。
    // 无论是通过"new"关键字对该类进行了初始化，还是通过"Cups.cup1"直接调用，静态代码块都会进行初始化
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups (){
        System.out.println("Cup class");
    }
}
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main");
        Cups.cup1.method(1);
    }
    //static Cups cups1 = new Cups();
    //static Cups cups2 = new Cups();
}
