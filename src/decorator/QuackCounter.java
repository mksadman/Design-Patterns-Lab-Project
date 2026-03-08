package decorator;

import interfaces.Observer;
import interfaces.Quackable;

/**
 * QuackCounter – transparently wraps any Quackable and counts every quack.
 * The static counter is shared across ALL instances, giving a grand total
 * for the entire simulation.
 *
 * Design Pattern: Decorator
 */
public class QuackCounter implements Quackable {

    private final Quackable duck;
    private static int numberOfQuacks = 0;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    /**
     * Delegates to the wrapped duck (which handles sound AND observer notification),
     * then increments the global quack counter.
     */
    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    /** Returns the total number of quacks counted across all instances. */
    public static int getQuacks() {
        return numberOfQuacks;
    }

    // ── Observer pass-through ──────────────────────────────────────────────

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }

    @Override
    public String toString() {
        return duck.toString();
    }
}
