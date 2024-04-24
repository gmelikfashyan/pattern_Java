package pr8.Visitor;

public class ConcreteRepairVisitor implements Visitor {
    @Override
    public void visit(BMW car) {
        System.out.println("Visiting and repairing BMW");
    }

    @Override
    public void visit(Mercedes car) {
        System.out.println("Visiting and repairing Mercedes");
    }
}
