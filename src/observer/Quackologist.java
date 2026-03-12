package observer;

import interfaces.Observer;
import interfaces.QuackObservable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Quackologist implements Observer {

    private static final DateTimeFormatter TIME_FMT =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    @Override
    public void update(QuackObservable duck) {
        System.out.println("  [Quackologist] " + duck
                + " just quacked at " + LocalTime.now().format(TIME_FMT));
    }
}
