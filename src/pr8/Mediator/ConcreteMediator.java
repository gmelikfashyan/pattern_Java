package pr8.Mediator;

public class ConcreteMediator implements Mediator{
    Button but;
    Engine engine;
    Accumulator accumulator;

    public void setBut(Button but) {
        this.but = but;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setAccumulator(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    public ConcreteMediator() {
    }

    public ConcreteMediator(Button but, Engine engine, Accumulator accumulator) {
        this.but = but;
        this.engine = engine;
        this.accumulator = accumulator;
    }

    public void press() {
        System.out.println("Button pressed");
        if (engine.isOn) {
            System.out.println("Engine is turned off");
            engine.turnOff();
        } else {
            engine.turnOn();
            System.out.println("Engine is turned on");
        }
    }
    public void start() {
        accumulator.isOn = true;
        System.out.println("Accumulator is on");
    }
    public void stop() {
        accumulator.isOn = false;
        System.out.println("Accumulator is off");
    }
}
