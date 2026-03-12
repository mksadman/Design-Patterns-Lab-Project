package factory;

import composite.Flock;
import interfaces.Quackable;
import observer.Quackologist;

public abstract class AbstractDuckFactory {

    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createRubberDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createGooseDuck();

    public Flock createFlock() {
        return new Flock();
    }

    public Quackologist createQuackologist() {
        return new Quackologist();
    }
}
