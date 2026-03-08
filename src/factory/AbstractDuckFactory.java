package factory;

import composite.Flock;
import interfaces.Quackable;
import observer.Quackologist;

/**
 * AbstractDuckFactory – declares the product-creation interface used by the
 * simulator.  Utility-object factories (Flock, Quackologist) are concrete
 * template methods here because they do not vary between concrete factories.
 *
 * Design Pattern: Abstract Factory
 */
public abstract class AbstractDuckFactory {

    // ── Abstract product methods (vary per concrete factory) ──────────────

    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createRubberDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createGooseDuck();

    // ── Concrete utility methods (same for every factory) ─────────────────

    /** Creates an empty Flock ready to accept Quackables. */
    public Flock createFlock() {
        return new Flock();
    }

    /** Creates a fresh Quackologist observer. */
    public Quackologist createQuackologist() {
        return new Quackologist();
    }
}
