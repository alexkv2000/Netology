package day12.PolishEntry;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическую формулу:");
        String input = scanner.nextLine();
        //String input = "7 − 2 * 3";
        System.out.println(input);

        LinkedList<Integer> numbers = new LinkedList<>(); //Очередь для цифр
        Deque<String> sign = new ArrayDeque<>(); //Стек для операций

        addElementForMatcher(input, numbers, getMatcher(input, "[\\d]+"), false);
        addElementForMatcher(input, sign, getMatcher(input, "[-*/+−]"), true);

        System.out.println();

        //вывод на консоль
        consolPop(numbers);
        consolPop(sign);
    }

    private static void addElementForMatcher(String input, Deque<String> sign, Matcher matcher, boolean console) {
        while (matcher.find()) {
            if (false) {
                System.out.print(input.substring(matcher.start(), matcher.end()) + " ");
            }
            sign.offerLast(input.substring(matcher.start(), matcher.end()));
        }
    }

    private static void addElementForMatcher(String input, LinkedList<Integer> numbers, Matcher matcher, boolean console) {
        while (matcher.find()) {
            if (console) {
                System.out.print(input.substring(matcher.start(), matcher.end()) + " ");
            }
            numbers.add(Integer.valueOf(input.substring(matcher.start(), matcher.end())));
        }
    }

    private static void consolPop(Deque<String> sign) {
        while (!sign.isEmpty()) {
            System.out.print(sign.pollLast() + " ");
        }
    }

    private static void consolPop(Queue<Integer> numbers) {
        while (!numbers.isEmpty()) {
            System.out.print(numbers.poll() + " ");
        }
    }

    private static Matcher getMatcher(String input, String reg) {
        Pattern pattern = Pattern.compile(reg); //регистрируем шаблон
        return pattern.matcher(input); //сопоставляем с каждым символом текста
    }
}
