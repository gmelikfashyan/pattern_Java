package pr6.FactoryMethod;

public class SedanCreator extends CarCreator{
    public Car makeCar() {
        return new Sedan();
    }
}
