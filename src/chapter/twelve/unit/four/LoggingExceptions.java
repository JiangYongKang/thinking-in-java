package chapter.twelve.unit.four;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment: Thinking in Java 12.4.1 异常记录与日志
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}
