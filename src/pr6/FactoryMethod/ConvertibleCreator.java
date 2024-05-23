package pr6.FactoryMethod;
public class ConvertibleCreator extends CarCreator{
    @Override
    public Car makeCar() {
        return new Convertible();
    }
}
