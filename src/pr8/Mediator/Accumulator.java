package pr8.Mediator;
public class Accumulator {
    private Mediator mediator;
    public boolean isOn = false;
    public Accumulator(Mediator mediator) {
        this.mediator = mediator;
    }
}
