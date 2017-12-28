package chapter.twelve.unit.four;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment:
 */
public class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
