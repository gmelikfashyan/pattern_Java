package pr2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
public class TestApp {
    public static void main(String[] args) {
        List<Human> list = new ArrayList<>();
        list.add(new Human(29, "Ivan", "Ivanov",
                LocalDate.of(1995, 01, 01), 75));
        list.add(new Human(4, "Ivan", "Ivanov",
                LocalDate.of(2020, 01, 01), 20));
        list.add(new Human(30, "Ivan", "Ivanov",
                LocalDate.of(1994, 01, 01), 91));
        Stream<Human> stream1 = list.stream();
        stream1.map(human -> new Human(human.age, human.firstName,
                        human.lastName, human.birthDate, human.weight+3))
                .forEach(System.out::println);
        list.forEach(human -> human.weight+=3);
        System.out.println("================");
        Stream<Human> stream2 = list.stream();
        stream2.sorted((human1, human2) -> human2.weight - human1.weight)
                .forEach(System.out::println);
        System.out.println("================");
        list.sort((human1, human2) -> human2.weight - human1.weight);
        Stream<Human> stream3 = list.stream();
        stream3.filter(human -> human.birthDate
                        .compareTo(LocalDate.of(2000, 01, 01)) < 0)
                .forEach(System.out::println);
        list.remove(2);
        Stream<Human> stream4 = list.stream();
        int sumAge = stream4.map(human -> human.age)
                .reduce(0, (acc, x) -> acc + x);
        System.out.println(sumAge);
    }
}
