package pr6.AbstractFactory;


public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Convertible convertible = carFactory.createConvertible();
        Sedan sedan = carFactory.createSedan();
        convertible.start();
        sedan.start();
    }
}
