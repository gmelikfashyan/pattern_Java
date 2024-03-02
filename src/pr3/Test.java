package pr3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static <Int> void main(String[] args) throws InterruptedException {
        /*Map<String, String> map = new HashMap<>();
        Thread firstTread = new Thread(() ->{ for (int i = 0; i < 100; i++) {
            map.put("Key" + i, "value" + i);
        }});
        Thread secondTread = new Thread(() ->{ for (int i = 50; i < 150; i++) {
            map.put("Key" + i, "value" + i);
        }});
        firstTread.start();
        secondTread.start();
        Thread.sleep(5000);
        System.out.println(map.size());
        System.out.println(map);

        MyMap<String, String> myMap = new MyMap<>();
        Thread firstMyTread = new Thread(() ->{ for (int i = 0; i < 100; i++) {
            myMap.put("Key" + i, "value" + i);
        }});
        Thread secondMyTread = new Thread(() ->{ for (int i = 50; i < 150; i++) {
            myMap.put("Key" + i, "value" + i);
        }});
        firstMyTread.start();
        secondMyTread.start();
        Thread.sleep(5000);
        System.out.println(myMap.size());
        System.out.println(myMap);*/



        Set<Integer> set = new HashSet<>();
        Thread firstSetTread = new Thread(() ->{ for (int i = 0; i < 100; i++) {
            set.add(i);
        }});
        Thread secondSetTread = new Thread(() ->{ for (int i = 50; i < 150; i++) {
            set.remove(i);
        }});
        firstSetTread.start();
        secondSetTread.start();
        Thread.sleep(5000);
        System.out.println(set.size());
        System.out.println(set);

        MySet<Integer> mySet = new MySet<>();
        Thread firstMySetTread = new Thread(() ->{ for (int i = 0; i < 100; i++) {
            mySet.add(i);
        }});
        Thread secondMySetTread = new Thread(() ->{ for (int i = 0; i < 10; i++) {
            mySet.remove(i);
        }});
        firstMySetTread.start();
        secondMySetTread.start();
        Thread.sleep(5000);
        System.out.println(mySet.size());
        System.out.println(mySet);
    }
}
