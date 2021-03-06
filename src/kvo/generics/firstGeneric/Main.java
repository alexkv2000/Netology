package kvo.generics.firstGeneric;

public class Main {
    public static <T> void main(String[] arg) {
        // параметризируем класс типом String
        Box<String> sample1 = new Box<>("Нетология");
        System.out.println(sample1);
        // параметризируем класс типом Integer
        Box<Integer> sample2 = new Box<>(1);
        System.out.println(sample2);
        // параметризируем класс типом Boolean
        Box<Boolean> sample3 = new Box<>(Boolean.TRUE);
        System.out.println(sample3);

    }
}
