package pr6.Builder;

public class Director {
    CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }
    public Car createCar(){
        return carBuilder.makeChassis().makeBody().chooseColor("red").build();
    }

}
