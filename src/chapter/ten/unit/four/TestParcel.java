package chapter.ten.unit.four;

/**
 * Author: vincent
 * Date: 2017-12-28 14:28:00
 * Comment: Think in Java 10.4 内部类与向上转型
 */
public class TestParcel {
    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        // 创建的内部类对象可以自动向上转型为接口
        Contents contents = parcel.contents();
        Destination destination = parcel.destination("Tasmania");
        System.out.println(destination.readLabel());
        System.out.println(contents.value());
    }
}
