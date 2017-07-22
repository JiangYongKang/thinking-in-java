package chapter13.unit3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA.
 * User: vincent
 * Date: 2017/7/22
 * Comment: Thinking in Java 13.3.1 无意识的递归
 */
public class ArrayListDisplay {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add(i + "");
        }
        System.out.println(strings.toString());
    }
}
