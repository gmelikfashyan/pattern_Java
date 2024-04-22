package pr6.Builder;

public class Car {
    private String color;
    private String chassis;
    private String body;

    public Car(String color, String chassis, String body) {
        this.color = color;
        this.chassis = chassis;
        this.body = body;
    }
    public boolean doCheck() {
        return ((chassis != null) && (body != null) && (color != null));
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Car [chassis=").append(chassis).append(", body=").append(body).append(", color=").append(color);
        return builder.toString();
    }
}
