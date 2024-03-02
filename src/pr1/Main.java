package pr1;


public class Main {
    public static void main(String[] args) {
        MyConsumer sortConsumer = new MyConsumer();
        Double [] arrayExample = {1., 2., 4.0, 1.2, 1.7, 1.1};
        sortConsumer.accept(arrayExample);
    }
}