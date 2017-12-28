package chapter.nine.unit.three;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/18
 * Comment: Thinking in Java 9.3.0 完全解耦
 */
class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    public Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    public Object process(Object input) {
        return String.valueOf(input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override
    public Object process(Object input) {
        return String.valueOf(input).toLowerCase();
    }
}

public class Apply {
    // 接口中形参为基类的引用，由于向上转型的特性，该基类下的全部子类都可以作为参数。
    // 导出类重写基类的方法后，看似调用的是基类的某个方法，实际上类型会自动判断，自动调用实际传入的导出类的被重写的方法。
    public static void process(Processor processor, Object s) {
        System.out.println("Using Process " + processor.name());
        System.out.println(processor.process(s));
    }

    public static void main(String[] args) {
        process(new Upcase(), "abcdefg");
    }
}
