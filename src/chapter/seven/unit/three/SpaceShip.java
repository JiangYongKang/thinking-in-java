package chapter.seven.unit.three;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.3.0 代理（继承方式实现代理）
 */
public class SpaceShip extends SpaceShipControls {
    private String name;

    public SpaceShip(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip("NSEA Protector");
        spaceShip.forward(100);
    }
}
