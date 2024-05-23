package pr6.Prototype;

public class StandartCar implements Car{
    private int horsepower;
    public StandartCar(int horsepower) {
        this.horsepower = horsepower;
    }
    @Override
    public Car clone() {
        return new StandartCar(horsepower);
    }
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    @Override
    public String toString() {
        return "StandartCar{" +
                "horsepower=" + horsepower +
                '}';
    }
}
