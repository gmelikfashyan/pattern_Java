package pr1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MyConsumer implements Consumer<Double[]> {
    @Override
    public void accept(Double[] arr) {
        ArrayList<Double> arrList = new ArrayList<>(List.of(arr));
        arrList.sort(Comparator.comparingDouble(Double::doubleValue));
        for (double i : arrList) {
            System.out.println(i);
        }
    }
}
