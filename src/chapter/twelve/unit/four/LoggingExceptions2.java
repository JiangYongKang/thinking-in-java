package chapter.twelve.unit.four;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment: Thinking in Java 12.4.1 捕获和记录他人编写的异常
 */
public class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggingExceptions2");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
}
