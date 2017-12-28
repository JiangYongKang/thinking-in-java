package chapter.five.unit.eight;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/5/14
 * Comment: 两个main方法的互相调用
 */
public class DynamicArray {
    public static void main(String[] args) {
        Other.main(new String[]{"one", "two", "three"});
    }
}

class Other {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }
    }
}
