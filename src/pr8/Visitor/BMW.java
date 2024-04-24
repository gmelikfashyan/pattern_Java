package pr8.Visitor;

public class BMW implements CarElement{
    void start() {
        System.out.println("Starting BMW...");
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
