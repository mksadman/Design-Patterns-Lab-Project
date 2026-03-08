import composite.Flock;
import decorator.QuackCounter;
import factory.AbstractDuckFactory;
import factory.CountingDuckFactory;
import interfaces.Quackable;
import observer.Quackologist;

/**
 * DuckSimulator – entry point for the Duck Simulator application.
 *
 * ╔══════════════════════════════════════════════════════════════════════════╗
 * ║  IMPORTANT CONSTRAINT                                                    ║
 * ║  ✅  All object creation is delegated to factory methods.               ║
 * ║  ❌  The `new` keyword does NOT appear anywhere in this class.           ║
 * ╚══════════════════════════════════════════════════════════════════════════╝
 *
 * Design Patterns demonstrated
 * ─────────────────────────────
 *  • Abstract Factory  – CountingDuckFactory produces all duck objects
 *  • Adapter           – GooseAdapter lets a Goose quack like a duck
 *  • Decorator         – QuackCounter wraps every duck to count quacks
 *  • Composite         – Flock treats a group of ducks as one Quackable
 *  • Iterator          – Flock uses an Iterator internally to traverse ducks
 *  • Observer          – Quackologist receives real-time quack notifications
 */
public class DuckSimulator {

    // ── Entry point ───────────────────────────────────────────────────────

    public static void main(String[] args) {
        simulate(CountingDuckFactory.getInstance());
    }

    // ── Simulation logic – zero `new` keywords below this line ───────────

    static void simulate(AbstractDuckFactory factory) {

        printBanner("Duck Simulator  |  Patterns: AbstractFactory · Adapter · "
                  + "Decorator · Composite · Iterator · Observer");

        // ── 1. Create individual ducks via factory (Decorator applied) ────
        Quackable mallardDuck  = factory.createMallardDuck();
        Quackable redheadDuck  = factory.createRedheadDuck();
        Quackable rubberDuck   = factory.createRubberDuck();
        Quackable duckCall     = factory.createDuckCall();
        Quackable gooseDuck    = factory.createGooseDuck();   // Adapter

        // ── 2. Build a sub-flock of four Mallards (Composite) ─────────────
        Flock flockOfMallards = factory.createFlock();
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());

        // ── 3. Build the main flock – mixes ducks AND a nested flock ──────
        Flock wholeFlock = factory.createFlock();
        wholeFlock.add(mallardDuck);
        wholeFlock.add(redheadDuck);
        wholeFlock.add(rubberDuck);
        wholeFlock.add(duckCall);
        wholeFlock.add(gooseDuck);
        wholeFlock.add(flockOfMallards);   // Composite nesting

        // ── 4. Create observer and register with the whole flock ──────────
        //      registerObserver() recurses into flockOfMallards automatically
        Quackologist quackologist = factory.createQuackologist();
        wholeFlock.registerObserver(quackologist);

        // ── 5. Simulate the whole flock ───────────────────────────────────
        printSection("Whole-Flock Simulation  (all ducks + nested mallard flock)");
        wholeFlock.quack();

        // ── 6. Simulate only the mallard sub-flock ────────────────────────
        printSection("Mallard Sub-Flock Simulation");
        flockOfMallards.quack();

        // ── 7. Simulate an individual duck not in any flock ───────────────
        printSection("Individual Simulation  (standalone Rubber Duck – no observer)");
        Quackable standaloneDuck = factory.createRubberDuck();
        standaloneDuck.quack();

        // ── 8. Report total quack count ───────────────────────────────────
        printSection("Quack Count Report");
        System.out.println("The ducks quacked a total of "
                + QuackCounter.getQuacks() + " time(s).");
    }

    // ── Formatting helpers (no object creation) ───────────────────────────

    private static void printBanner(String text) {
        String line = "═".repeat(text.length() + 4);
        System.out.println("\n╔" + line + "╗");
        System.out.println("║  " + text + "  ║");
        System.out.println("╚" + line + "╝\n");
    }

    private static void printSection(String title) {
        System.out.println("\n── " + title + " ──");
    }
}
