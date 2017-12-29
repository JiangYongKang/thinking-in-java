package chapter.ten.unit.eight.two;

/**
 * Author: vincent
 * Date: 2017-12-29 13:55:00
 * Comment: Think in Java 10.8.2 内部类与控制框架
 * 在目前的设计中我们并不知道 Event 类做了什么， 这正是此设计关机所在 “使变化的事物与不变的事物相互分离”
 * 我们可以创建不同的 Event 子类来展现出不同的行为
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls controls = new GreenhouseControls();
        controls.addEvent(controls.new Bell(900));

        Event[] events = {
                controls.new ThermostatNight(0),
                controls.new LightOn(200),
                controls.new LightOff(400),
                controls.new WaterOn(600),
                controls.new WaterOff(800),
                controls.new ThermostatDay(1400)
        };

        controls.addEvent(controls.new Restart(2000, events));
        if (args.length == 1) {
            controls.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        }

        controls.run();
    }
}
