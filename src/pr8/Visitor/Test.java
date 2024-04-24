package pr8.Visitor;

public class Test {
    public static void main(String[] args) {
        Visitor repairVisitor = new ConcreteRepairVisitor();
        Visitor parkingVisitor = new ParkingVisitor();
        BMW bmw = new BMW();
        Mercedes mercedes = new Mercedes();
        bmw.accept(repairVisitor);
        mercedes.accept(repairVisitor);
        bmw.accept(parkingVisitor);
        mercedes.accept(parkingVisitor);
    }
}
