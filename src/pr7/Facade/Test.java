package pr7.Facade;

public class Test {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();
        carFacade.startCar();
        carFacade.stopCar();
    }
}
