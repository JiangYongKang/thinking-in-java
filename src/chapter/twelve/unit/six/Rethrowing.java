package chapter.twelve.unit.six;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment: Thinking in Java 12.6.2 重新抛出异常
 * 1. 异常对象都是通过 "new" 关键字在对上简历的对象，垃圾回收机制会自动清理他们
 * 2. 有可能在捕获异常之后抛出新的异常，有关原来的异常发生的信息点会丢失，剩下的全部是与新的抛出点有关的信息
 */
public class Rethrowing {

    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("throw from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(), e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(), e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

    }

}
