package chapter.seven.unit.three;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/6/3
 * Comment: Thinking in Java 7.3.0 代理（组合方式实现代理）
 */
public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        SpaceShipDelegation delegation = new SpaceShipDelegation("NSEA Protector");
        delegation.forward(100);
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void back(int velocity) {
        controls.back(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }
}
