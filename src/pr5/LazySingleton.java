package pr5;

public class LazySingleton {
    private static LazySingleton INSTANCE;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
            return INSTANCE;
        }
        return INSTANCE;
    }
    public void print() {
        System.out.println("LazySingleton");
    }
}
