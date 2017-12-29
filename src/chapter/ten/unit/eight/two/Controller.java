package chapter.ten.unit.eight.two;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vincent
 * Date: 2017-12-29 13:32:00
 * Comment: Think in Java 10.8.2 内部类与控制框架
 */
public class Controller {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public void run() {
        while (events.size() > 0) {
            for (Event e : new ArrayList<>(events)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    events.remove(e);
                }
            }
        }
    }
}
