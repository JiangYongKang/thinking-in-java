package chapter.eight.unit.four;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/11
 * Comment: Thinking in Java 8.4.0 协变返回类型
 * 导出类中覆盖基类的方法可以返回基类方法的返回值类型的导出类型
 */
class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    public Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    @Override
    public Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill mill = new Mill();
        System.out.println(mill.process());
        WheatMill wheatMill = new WheatMill();
        System.out.println(wheatMill.process());
    }
}
