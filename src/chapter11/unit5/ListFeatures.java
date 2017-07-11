package chapter11.unit5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment:
 */
public class ListFeatures {
    public static void main(String[] args) {
        Random random = new Random(47);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(random.nextInt()));
        }
        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }

    }
}
