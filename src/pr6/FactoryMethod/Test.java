package pr6.FactoryMethod;

public class Test {
    public static void main(String[] args) {
        ConvertibleCreator convertibleCreator = new ConvertibleCreator();
        convertibleCreator.takeCar();
        SedanCreator sedanCreator = new SedanCreator();
        sedanCreator.takeCar();
    }
}
