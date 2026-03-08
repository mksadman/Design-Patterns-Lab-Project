package interfaces;

/**
 * Quackable interface – core abstraction for all duck-like objects.
 * Extends QuackObservable so every Quackable is also an observable subject.
 *
 * Design Pattern: Observer (Subject interface)
 */
public interface Quackable extends QuackObservable {
    void quack();
}
