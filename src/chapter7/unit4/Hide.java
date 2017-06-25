package chapter7.unit4;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.4.2 名称屏蔽
 * 基类拥有某个已经被多次重载的方法，那么在导出类中重新定义该方法名称时，不会覆盖任何基类中的方法。
 */
class Homer {
    public char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    public float doh(float f) {
        System.out.println("doh(float)");
        return 1.0F;
    }
}

class Milhouse {
}

class Bart extends Homer {
    public void doh(Milhouse milhouse) {
        System.out.println("doh(Milhouse)");
    }
}

public class Hide {
    public static void main(String[] args) {
        Bart bart = new Bart();
        bart.doh('A');
        bart.doh(1);
        bart.doh(1.0F);
        bart.doh(new Milhouse());
    }
}
