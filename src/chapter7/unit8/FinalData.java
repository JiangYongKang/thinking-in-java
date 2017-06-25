package chapter7.unit8;

import java.util.Random;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.8.1 final 关键字
 */
public class FinalData {
    private static Random random = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;

    public static final int VALUE_THREE = 39;

    private final int i4 = random.nextInt(20);
    static final int INT_5 = random.nextInt(20);

    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);

    private static final Value VAL_3 = new Value(33);

    private final int[] a = {1, 2, 3, 4, 5};

    @Override
    public String toString() {
        return "id: " + id + ", i4: " + i4 + ", INT_5: " + INT_5;
    }

    public static void main(String[] args) {
        FinalData finalData1 = new FinalData("finalData1");
        // finalData1.valueOne++; 被final关键字修饰的基本数据类型的值不可改变
        finalData1.v2.i++; // 被final修饰的对象引用虽然是不可改变的，但是该对象内的属性值不是final的，依然可以被改变
        finalData1.v1 = new Value(22); // 没有被final修饰的对象引用可以重新指向新的对象
        for (int i = 0; i < finalData1.a.length; i++) {
            finalData1.a[i]++; // 虽然数组a被final修饰了，数组的引用无法指向其他新的对象，但是其数组内部的值也是可以被改变的
        }

        // finalData1.v2 = new Value(22); 被final修饰的对象引用无法重新指向新的对象
        // finalData1.VAL_3 = new Value(33);
        // finalData1.a = new int[3];

        System.out.println(finalData1);
        FinalData finalData2 = new FinalData("finalData2");
        System.out.println(finalData1);
        System.out.println(finalData2);
    }
}
