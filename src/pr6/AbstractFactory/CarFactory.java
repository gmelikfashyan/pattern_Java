package pr6.AbstractFactory;
public class CarFactory implements AbstractFactory{
    @Override
    public Convertible createConvertible() {
        return new Convertible();
    }

    @Override
    public Sedan createSedan() {
        return new Sedan();
    }
}
