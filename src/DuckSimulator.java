import composite.Flock;
import decorator.QuackCounter;
import factory.AbstractDuckFactory;
import factory.CountingDuckFactory;
import interfaces.Quackable;
import observer.Quackologist;

public class DuckSimulator {

    public static void main(String[] args) {
        simulate(CountingDuckFactory.getInstance());
    }

    static void simulate(AbstractDuckFactory factory) {

        System.out.println("\n--- Duck Simulator (AbstractFactory, Adapter, Decorator, Composite, Iterator, Observer) ---\n");

        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable rubberDuck = factory.createRubberDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable gooseDuck = factory.createGooseDuck();

        // create a sub-flock of 4 mallards
        Flock flockOfMallards = factory.createFlock();
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());

        // whole flock contains everything
        Flock wholeFlock = factory.createFlock();
        wholeFlock.add(mallardDuck);
        wholeFlock.add(redheadDuck);
        wholeFlock.add(rubberDuck);
        wholeFlock.add(duckCall);
        wholeFlock.add(gooseDuck);
        wholeFlock.add(flockOfMallards);

        Quackologist quackologist = factory.createQuackologist();
        wholeFlock.registerObserver(quackologist);

        System.out.println("\n-- Whole Flock --");
        wholeFlock.quack();

        System.out.println("\n-- Mallard Sub-Flock --");
        flockOfMallards.quack();

        // standalone duck, not in any flock so no observer
        System.out.println("\n-- Standalone Rubber Duck --");
        Quackable standaloneDuck = factory.createRubberDuck();
        standaloneDuck.quack();

        System.out.println("\nTotal quacks: " + QuackCounter.getQuacks());
    }
}