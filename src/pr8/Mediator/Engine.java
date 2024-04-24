package pr8.Mediator;

public class Engine{
    private Mediator mediator;
    public boolean isOn = false;

    public Engine(Mediator mediator) {
        this.mediator = mediator;
    }
    public void turnOn() {
        mediator.start();
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
        mediator.stop();
    }
}
