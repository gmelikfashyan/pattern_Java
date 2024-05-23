package pr6.Builder;
public class Test {
    public static void main(String[] args) {
        SportCarBuilder sportCarBuilder = new SportCarBuilder();
        StandartCarBuilder standartCarBuilder = new StandartCarBuilder();
        Director director1 = new Director(sportCarBuilder);
        Director director2 = new Director(standartCarBuilder);
        Car sportCar = director1.createCar();
        Car standartCar = director2.createCar();
        System.out.println(sportCar.toString());
        System.out.println(standartCar.toString());
    }
}
