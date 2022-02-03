package kvo.generics.twoGeneric;

public class Main {
    public static void main(String a[]) {
        // параметризируем класс типом String для ключа и значения
        Box<String, String> sample1 = new Box<>("имя", "Нетология");
        System.out.println(sample1);
        // параметризируем класс типом Integer для ключа и Boolean для значения
        Box<Integer, Boolean> sample2 = new Box<>(1, Boolean.TRUE);
        System.out.println(sample2);
        Box<Integer, String> sample3 = new Box<>(1, "String.TRUE");
        System.out.println(sample3);

    }
}
