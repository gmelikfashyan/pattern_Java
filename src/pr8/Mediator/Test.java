package pr8.Mediator;

public class Test {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Engine engine = new Engine(mediator);
        Button button = new Button(mediator);
        Accumulator accumulator = new Accumulator(mediator);
        mediator.setBut(button);
        mediator.setAccumulator(accumulator);
        mediator.setEngine(engine);
        button.press();
        button.press();
    }
}
