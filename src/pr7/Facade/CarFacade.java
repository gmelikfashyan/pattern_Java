package pr7.Facade;

public class CarFacade {
    Key key;
    Engine engine;
    Display display;

    public CarFacade() {
        key = new Key();
        engine = new Engine();
        display = new Display();
    }

    public void startCar() {
        key.insert();
        display.turnOn();
        engine.start();
    }
    public void stopCar() {
        engine.stop();
        display.turnOff();
        key.pullOut();
    }
}
