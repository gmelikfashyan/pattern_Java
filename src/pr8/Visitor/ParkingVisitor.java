package pr8.Visitor;

public class ParkingVisitor implements Visitor{
    @Override
    public void visit(Mercedes car) {
        System.out.println("Parking Mercedes");
    }

    @Override
    public void visit(BMW car) {
        System.out.println("Parking BMW");
    }
}
