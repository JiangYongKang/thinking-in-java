package chapter.twelve.unit.eight;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment: Thinking in Java 12.8.0 使用 finally 进行清理
 */
public class ThreeException extends Exception {
    private static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No Exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) {
                    break;
                }
            }
        }

    }
}
