package pr6.Prototype;

public class Tset {
    public static void main(String[] args) {
        Car sportCar = new SportCar(700);
        Car standartCar = new StandartCar(250);
        Car clonedSportCar = sportCar.clone();
        Car clonedStandartCar = standartCar.clone();
        clonedStandartCar.setHorsepower(340);
        System.out.println(clonedSportCar.toString());
        System.out.println(clonedStandartCar.toString());
    }
}
