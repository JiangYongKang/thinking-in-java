package chapter12.unit6;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment: Thinking in Java 12.6.0 捕获所有异常
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("MyException");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("GetMessage() " + e.getMessage());
            System.out.println("GetLocalizedMessage() " + e.getLocalizedMessage());
            System.out.println("ToString() " + e);
            System.out.println("PrintStackTrace() ");
            e.printStackTrace(System.out);
        }
    }
}
