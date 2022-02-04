package kvo;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = string -> parse(string);
        Integer integer = toInteger.apply("5");
        System.out.println(integer);
    }

    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}