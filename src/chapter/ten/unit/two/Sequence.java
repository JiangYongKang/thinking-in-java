package chapter.ten.unit.two;

/**
 * Author: vincent
 * Date: 2017/7/10
 * Comment: Thinking in Java 10.2.0 链接到外部类
 * 1. 内部类自动拥有对其外部类的所有成员的访问权
 * 2. 内部类的对象只能在与其外围的对象相关联的情况下才能创建（非 static 的内部类），
 * 3. 记住！静态修饰的变量、方法、类，都是与类相关联，而并不是与类的实例化对象相关联。
 * 4. 这也是为什么静态修饰的变量、属性、方法、类可以不创建对象而直接通过类名调用的原因。
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    // 构造该类时，必须为类内部的数组分配初始化发小
    public Sequence(int size) {
        items = new Object[size];
    }

    // 检查数组大小，并向数组内添加元素
    public void add(Object object) {
        if (next < items.length) {
            items[next++] = object;
        }
    }

    // 私有内部类，实现了 Selector 接口。
    private class SequenceSelector implements Selector {
        private int i = 0;

        // 检查外部数组对象是否到了尾部
        @Override
        public boolean end() {
            return i == items.length;
        }

        // 访问当前对象
        @Override
        public Object current() {
            return items[i];
        }

        // 移动下标到数组的下一个
        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    // 外部类的方法，返回一个私有内部类的接口对象
    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        // 创建一个 Sequence 对象，并为该对象内部的数组赋值
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }

        // 通过外部类的方法构建出内部类的对象引用，并迭代输出
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
