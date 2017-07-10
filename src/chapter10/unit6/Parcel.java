package chapter10.unit6;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/10
 * Comment: Thinking in Java 10.6.0 匿名内部类
 */
public class Parcel {

    public Contents contents() {
        // 创建一个实现 Contents 接口的匿名对象
        // 并且自动向上转型为 Contents 对象
        // 这里的语义并非是实例化一个 Contents ？？？，接口不可以被实例化！！
        return new Contents() {
            private int i = 100;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Contents contents = parcel.contents();
        System.out.println(contents.value());
    }
}
