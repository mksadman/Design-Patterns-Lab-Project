package observer;

import interfaces.Observer;
import interfaces.QuackObservable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Quackologist – concrete Observer that logs every quack event in real time.
 * Prints which duck quacked and the exact time the notification arrived.
 *
 * Design Pattern: Observer (ConcreteObserver)
 */
public class Quackologist implements Observer {

    private static final DateTimeFormatter TIME_FMT =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    @Override
    public void update(QuackObservable duck) {
        System.out.println("  [Quackologist] " + duck
                + " just quacked at " + LocalTime.now().format(TIME_FMT));
    }
}
