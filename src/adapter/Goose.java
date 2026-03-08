package adapter;

/**
 * Goose – an incompatible class that speaks a different language (honk).
 * It is NOT a Quackable; GooseAdapter bridges the gap.
 */
public class Goose {

    public void honk() {
        System.out.println("Honk");
    }

    @Override
    public String toString() {
        return "Goose";
    }
}
