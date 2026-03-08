package adapter;

import interfaces.Observer;
import interfaces.Quackable;
import observer.Observable;

/**
 * GooseAdapter – wraps a Goose so it can be used wherever a Quackable is expected.
 * Calling quack() delegates to goose.honk() transparently.
 *
 * Design Pattern: Adapter (Object Adapter)
 * Design Pattern: Observer (ConcreteSubject, via Observable helper)
 */
public class GooseAdapter implements Quackable {

    private final Goose goose;
    private final Observable observable;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
        observable = new Observable(this);
    }

    /** Adapts quack() → honk() and then notifies any registered observers. */
    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public String toString() {
        return "Goose pretending to be a Duck";
    }
}
