package chapter.ten.unit.three;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/10
 * Comment: Thinking in Java 10.3.2 使用 ".new"
 */
public class Parcel {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String whereTo) {
            this.label = whereTo;
        }

        public String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Parcel.Contents contents = parcel.new Contents();
        Parcel.Destination destination = parcel.new Destination("Tasmania");
    }
}
