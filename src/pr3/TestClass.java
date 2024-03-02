package lab3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {

        // Пробуем обойтись без потокобезопасного интерфейса
        HashMap<String, Integer> map = new HashMap<>();
        // Запускаем потоки
        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("Key" + i, i);
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put("Key" + i, i);
            }
        });

        one.start();
        two.start();
        // Ждем пока они завершаться
        one.join();
        two.join();
        // Получаем неверный и нестабильный результат
        System.out.println("Размер Map: " + map.size());
        System.out.println("" + map);


        // С использование потокобезопасного интерфейса
        lab3.LockedMap<String, Integer> safeMap = new lab3.LockedMap<>();

        Thread safeOne = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeMap.put("Key" + i, i);
            }
        });
        Thread safeTwo = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                safeMap.put("Key" + i, i);
            }
        });

        safeOne.start();
        safeTwo.start();

        safeOne.join();
        safeTwo.join();

        System.out.println("Размер Map: " + safeMap.size());
        System.out.println(safeMap);
    }
}