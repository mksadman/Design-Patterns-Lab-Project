package interfaces;

/**
 * Observable side of the Observer Pattern.
 * Every Quackable duck is also a QuackObservable so that
 * registered observers are notified on every quack.
 */
public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
