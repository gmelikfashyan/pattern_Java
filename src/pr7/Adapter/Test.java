package pr7.Adapter;

public class Test {
    public static void main(String[] args) {
        Mercedes mercedes = new Mercedes();
        M4 m4 = new M4();
        MercedesAdapter mercedesAdapter = new MercedesAdapter(mercedes);
        Client client = new Client();
        client.startCar(m4);
        client.startCar(mercedesAdapter);
    }
}
