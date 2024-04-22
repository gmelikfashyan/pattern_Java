package pr7.Adapter;

public class MercedesAdapter implements BMW{
    Mercedes mercedes;

    public MercedesAdapter(Mercedes mercedes) {
        this.mercedes = mercedes;
    }

    @Override
    public void sayHello() {
        mercedes.sayHello();
    }
}
