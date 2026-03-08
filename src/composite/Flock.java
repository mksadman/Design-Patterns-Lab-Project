package composite;

import interfaces.Observer;
import interfaces.Quackable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Flock – a composite container of Quackables.
 * Treats a group of ducks exactly the same as an individual duck.
 *
 * Design Pattern: Composite
 * Design Pattern: Iterator  (used internally when traversing the collection)
 * Design Pattern: Observer  (propagates registration to every member,
 *                 including nested flocks, so observers receive per-duck events)
 */
public class Flock implements Quackable {

    private final List<Quackable> quackers = new ArrayList<>();

    /** Add any Quackable – an individual duck or another Flock. */
    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    /**
     * Calls quack() on every member using an Iterator.
     * Each duck handles its own observer notifications independently.
     */
    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }

    /**
     * Registers the observer with every duck in the flock (recursively if
     * the member is itself a Flock).
     */
    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.registerObserver(observer);
        }
    }

    /** Not needed at the flock level; each leaf duck notifies directly. */
    @Override
    public void notifyObservers() {
        // Intentionally empty – individual ducks notify observers themselves.
    }

    @Override
    public String toString() {
        return "Flock of Ducks";
    }
}
