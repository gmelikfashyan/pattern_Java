package pr6.FactoryMethod;

public class Convertible implements Car{
    @Override
    public void start() {
        System.out.println("Starting convertible car...");
    }
}
