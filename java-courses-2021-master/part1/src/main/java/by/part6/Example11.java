package by.part6;

import java.util.HashMap;
import java.util.Map;

public class Example11 {

  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      map.putIfAbsent(i, "val" + i);
    }

    System.out.println("~putIfAbsent~\n" + map);
    map.forEach((key, val) -> System.out.println(key + " = " + val));

//код показывает как использовать для вычислений код при помощи различных функций:
    map.computeIfPresent(3, (num, val) -> val + num);
    map.get(3);             // val33

    map.computeIfPresent(9, (num, val) -> null);
    map.containsKey(9);     // false

    map.computeIfAbsent(23, num -> "val" + num);
    map.containsKey(23);    // true

    map.computeIfAbsent(3, num -> "bam");
    map.get(3);             // val33

//как удалить объект по ключу, только если этот объект ассоциирован с ключом:
    map.remove(3, "val3");
    map.get(3);             // val33

    map.remove(3, "val33");
    map.get(3);             // null
    System.out.println(map);

//Еще один полезный метод:
    map.getOrDefault(42, "not found");  // not found

//Объединить записи двух массивов? Легко:
    map.merge(9, "val9", String::concat);
    map.get(9);             // val9

    map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
    map.get(9);             // val9concat
  }
}
