package chapter01.unit7;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/5/7
 * Comment: 企鹅类，继承自鸟类
 */
public class Penguin extends Bird {
    @Override
    public void move() {
        System.out.println("this is Penguin class move method ... ");
    }
}
