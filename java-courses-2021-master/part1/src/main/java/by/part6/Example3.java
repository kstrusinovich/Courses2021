package by.part6;

public class Example3 {

  @FunctionalInterface
  interface Converter<F, T> {

    T convert(F from);
  }

  public static void main(String[] args) {
    Converter<String, Integer> converter = Integer::valueOf;

    Integer converted = converter.convert("123");
    System.out.println(converted);    // 123
  }
}
