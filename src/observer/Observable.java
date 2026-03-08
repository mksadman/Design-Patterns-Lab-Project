package observer;

import interfaces.Observer;
import interfaces.QuackObservable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Observable – reusable delegate composed by each concrete duck to manage
 * its observer list, avoiding code duplication across duck classes.
 *
 * Design Pattern: Observer (Subject / Observable helper)
 */
public class Observable implements QuackObservable {

    private final List<Observer> observers = new ArrayList<>();
    private final QuackObservable duck;   // back-reference so observers receive the real duck

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer obs = iterator.next();
            obs.update(duck);
        }
    }
}
