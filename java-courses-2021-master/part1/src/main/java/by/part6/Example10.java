package by.part6;

import by.part6.Example4.Person;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Example10 {

  public static void main(String[] args) {
    List<String> stringCollection = Arrays.asList(
        "ddd2",
        "aaa2",
        "bbb1",
        "aaa1",
        "bbb3",
        "ccc",
        "bbb2",
        "ddd1"
    );

    //filter
    System.out.println("~filter~");
    stringCollection
        .stream()
        .filter((s) -> s.startsWith("a"))
        .forEach(System.out::println);
    //sorted
    System.out.println("~sorted~");
    stringCollection
        .stream()
        .filter((s) -> s.startsWith("a"))
        .sorted()
        .forEach(System.out::println);

    //map
    System.out.println("~map~");
    stringCollection
        .stream()
        .map(String::toUpperCase)
        .map(x -> "*" + x)
        .sorted((a, b) -> b.compareTo(a))
        .forEach(System.out::println);

    //match
    System.out.println("~match~");
    boolean anyStartsWithA =
        stringCollection
            .stream()
            .anyMatch((s) -> s.startsWith("a"));

    System.out.println("anyMatch = " + anyStartsWithA);      // true

    boolean allStartsWithA =
        stringCollection
            .stream()
            .allMatch((s) -> s.startsWith("a"));

    System.out.println("allMatch = " + allStartsWithA);      // false

    boolean noneStartsWithZ =
        stringCollection
            .stream()
            .noneMatch((s) -> s.startsWith("z"));

    System.out.println("noneMatch = " + noneStartsWithZ);      // true

    //count
    System.out.println("~count~");
    long startsWithB =
        stringCollection
            .stream()
            .filter((s) -> s.startsWith("b"))
            .count();

    System.out.println("count = " + startsWithB);    // 3

    //reduce
    Optional<String> reduced =
        stringCollection
            .stream()
            .filter((s) -> s.startsWith("b"))
            .sorted()
            .reduce((s1, s2) -> s1 + "#" + s2);

    reduced.ifPresent(System.out::println);

    System.out.println("~person~");
    Collection<Person> personCollection = Arrays.asList(
        new Person("abramovich", "artem"),
        new Person("petrovich", "ivan"),
        new Person("abrosimov", "yury")
    );
    Optional<String> personReduced =
        personCollection
            .stream()
            .map(x -> x.firstName)
            .filter((s) -> s.startsWith("z"))
            .sorted()
            .reduce((s1, s2) -> s1 + "," + s2);

    System.out.println(personReduced.orElseThrow(() -> new IllegalArgumentException("Cannot find value")));
  }
}
