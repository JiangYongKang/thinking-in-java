package chapter10.unit5;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/10
 * Comment: Thinking in Java 10.5.1 在方法和作用域内的内部类
 */
public class Parcel {

    // 方法内的内部类
    public Destination destination(String s) {
        // 这个内部类被声明在一个方法里面，被称为方法内部类，也可以叫做局部内部类
        // PDestination 类被声明在了 destination() 方法中
        // 也就意味着 PDestination 是属于 destination() 方法的
        // 方法内部类和变量作用域遵循同样的规则，在方法内，该类可以被访问。
        // 在方法之外，不可以访问该类
        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        // 自动向上转型
        return new PDestination(s);
    }

    // 作用域内的内部类
    private void internalTracking(boolean b) {
        // 作用域内的内部类只可以在 if 的范围中访问
        if (b) {
            class TrackingSlip {
                private String id;

                public TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }

            TrackingSlip trackingSlip = new TrackingSlip("slip");
            String s = trackingSlip.getSlip();
            System.out.println(s);
        }
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Destination destination = parcel.destination("Tasmania");
        System.out.println(destination.readLabel());
        parcel.track();
    }
}
