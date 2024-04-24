package pr8.Visitor;

public class Mercedes implements CarElement{
    void start() {
        System.out.println("Starting Mercedes...");
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
