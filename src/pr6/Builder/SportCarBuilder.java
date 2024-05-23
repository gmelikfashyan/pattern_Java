package pr6.Builder;

public class SportCarBuilder implements CarBuilder{
    private String color;
    private String chassis;
    private String body;
    @Override
    public CarBuilder makeChassis() {
        this.chassis = "Sport chassis";
        return this;
    }
    @Override
    public CarBuilder makeBody() {
        this.body = "Sport body";
        return this;
    }
    @Override
    public CarBuilder chooseColor(String color) {
        this.color = color;
        return this;
    }
    public Car build() {
        Car car = new Car(this.color, this.chassis, this.body);
        if (car.doCheck()) {
            return car;
        }
        else {
            return null;
        }
    }
}
