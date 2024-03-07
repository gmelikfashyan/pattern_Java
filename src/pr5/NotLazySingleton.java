package pr5;

public class NotLazySingleton {
    private static final NotLazySingleton INSTANCE = new NotLazySingleton();
    private NotLazySingleton() {}
    public static NotLazySingleton getInstance() {
        return INSTANCE;
    }
    public void print() {
        System.out.println("NotLazySingleton");
    }
}
