package day12.PolishEntry;

import org.jetbrains.annotations.NotNull;

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
        Stack<String> sign = new Stack<>(); //Стек для операций

        Matcher matcher = getMatcher(input, "[\\d]+");
        addElementForMatcher(input, numbers, matcher, false);

        matcher = getMatcher(input, "[-*/+−]");
        addElementForMatcher(input, sign, matcher, true);
        System.out.println();

        //вывод на консоль
        consolPop(numbers);
        consolPop(sign);
    }

    private static void addElementForMatcher(String input, Stack<String> sign, @NotNull Matcher matcher, boolean console) {
        while (matcher.find()) {
            if (false) {
                System.out.print(input.substring(matcher.start(), matcher.end()) + " ");
            }
            sign.add(input.substring(matcher.start(), matcher.end()));
        }
    }

    private static void addElementForMatcher(String input, LinkedList<Integer> numbers, @NotNull Matcher matcher, boolean console) {
        while (matcher.find()) {
            if (console) {
                System.out.print(input.substring(matcher.start(), matcher.end()) + " ");
            }
            numbers.add(Integer.valueOf(input.substring(matcher.start(), matcher.end())));
        }
    }

    private static void consolPop(@NotNull Stack<String> sign) {
        while (!sign.isEmpty()) {
            System.out.print(sign.peek() + " ");
            sign.pop();
        }
    }

    private static void consolPop(@NotNull Queue<Integer> numbers) {
        while (!numbers.isEmpty()) {
            System.out.print(numbers.poll() + " ");
        }
    }

    private static @NotNull Matcher getMatcher(String input, String reg) {
        Pattern pattern = Pattern.compile(reg); //регистрируем шаблон
        return pattern.matcher(input); //сопоставляем с каждым символом текста
    }
}
