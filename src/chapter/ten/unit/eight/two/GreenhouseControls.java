package chapter.ten.unit.eight.two;

import java.util.Arrays;

/**
 * Author: vincent
 * Date: 2017-12-29 13:40:00
 * Comment: Think in Java 10.8.2 内部类与控制框架
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class Restart extends Event {
        private Event[] events;

        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            Arrays.stream(events).forEach(GreenhouseControls.this::addEvent);
        }

        @Override
        public void action() {
            Arrays.stream(events).forEach((e) -> {
                e.start();
                addEvent(e);
            });
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }
}
