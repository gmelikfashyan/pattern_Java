package pr5;

public class HolderSingleton {
    private HolderSingleton() {}
    private static final class SingletonHolder {
        public static final HolderSingleton HOLDER_SINGLETON = new HolderSingleton();
    }
    public static HolderSingleton getInstance() {
        return SingletonHolder.HOLDER_SINGLETON;
    }
    public void print() {
        System.out.println("HolderSingleton");
    }
}
