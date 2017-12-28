package chapter.eight.unit.three;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/11
 * Comment: Thinking in Java 8.3.3 构造器内部的多态方法的行为
 */
class Glyph {
    public void draw() {
        System.out.println("Glyph -> draw()");
    }

    public Glyph() {
        System.out.println("Glyph() before draw()");
        /**
         * 在构造器内部调用一个被导出类覆盖的方法可能会产生的隐患
         * 1. 动态绑定是在运行时决定的，因为对象无法知道它是属于方法所在的那个类，还是属于那个类的导出类。
         * 2. 如下，该方法并不会调用 Glyph 类中的 draw() 方法，它调用的是导出类 RoundGlyph 类中的 draw() 方法
         * 3. 但是 RoundGlyph 类中的属性还未被赋值，所以输出的是 0 而并不是 100
         * 4. 在构造器中调用方法是可以的，但是该方法最好是 final 或者 private 的。
         * 5. 因为被 final、private 修饰的方法无法被导出类覆盖，也就会避免如下情况。
         */
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 0;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph -> RoundGlyph(), radius = " + radius);
    }

    @Override
    public void draw() {
        System.out.println("RoundGlyph -> draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(100);
        // Glyph() before draw()
        // RoundGlyph -> draw(), radius = 0
        // Glyph() after draw()
        // RoundGlyph -> RoundGlyph(), radius = 100
    }
}
