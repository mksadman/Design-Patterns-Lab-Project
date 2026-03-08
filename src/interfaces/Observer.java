package interfaces;

/**
 * Observer interface for the Observer Pattern.
 * Concrete observers (e.g. Quackologist) receive
 * real-time notifications whenever a duck quacks.
 */
public interface Observer {
    void update(QuackObservable duck);
}
