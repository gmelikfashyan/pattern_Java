package pr6.Builder;

public interface CarBuilder {
    CarBuilder makeChassis();
    CarBuilder makeBody();
    CarBuilder chooseColor(String color);
    Car build();
}
