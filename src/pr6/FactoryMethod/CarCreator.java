package pr6.FactoryMethod;
public abstract class CarCreator {
    abstract public Car makeCar();
    public void takeCar() {
        Car car = makeCar();
        car.start();
    }
}
