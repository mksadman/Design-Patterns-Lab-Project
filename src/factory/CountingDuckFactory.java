package factory;

import adapter.Goose;
import adapter.GooseAdapter;
import decorator.QuackCounter;
import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedheadDuck;
import ducks.RubberDuck;
import interfaces.Quackable;

/**
 * CountingDuckFactory – creates ducks wrapped in a QuackCounter decorator
 * so every quack is automatically tallied.
 *
 * Design Pattern: Abstract Factory (ConcreteFactory)
 * Design Pattern: Decorator       (applied transparently during construction)
 */
public class CountingDuckFactory extends AbstractDuckFactory {

    /**
     * Static factory method – the only way to obtain a CountingDuckFactory.
     * Keeps main() free of the {@code new} keyword.
     */
    public static AbstractDuckFactory getInstance() {
        return new CountingDuckFactory();
    }

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createGooseDuck() {
        return new QuackCounter(new GooseAdapter(new Goose()));
    }
}
