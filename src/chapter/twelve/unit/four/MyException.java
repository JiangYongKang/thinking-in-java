package chapter.twelve.unit.four;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment: Thinking in Java 12.4.1 自定义异常
 */
public class MyException extends Exception {
    private int x;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, int x) {
        super(message);
        this.x = x;
    }

    public int val() {
        return x;
    }

    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}
