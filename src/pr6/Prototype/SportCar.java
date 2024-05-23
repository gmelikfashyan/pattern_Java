package pr6.Prototype;
public class SportCar implements Car{
    private int horsepower;
    public SportCar(int horsepower) {
        this.horsepower = horsepower;
    }
    @Override
    public Car clone() {
        return new SportCar(horsepower);
    }
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    @Override
    public String toString() {
        return "SportCar{" +
                "horsepower=" + horsepower +
                '}';
    }
}
