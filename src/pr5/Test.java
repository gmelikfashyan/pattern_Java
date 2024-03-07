package pr5;

public class Test {
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        NotLazySingleton notLazySingleton = NotLazySingleton.getInstance();
        HolderSingleton holderSingleton = HolderSingleton.getInstance();
        lazySingleton.print();
        notLazySingleton.print();
        holderSingleton.print();
    }
}
