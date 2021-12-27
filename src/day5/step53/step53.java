package day5.step53;

import java.util.Scanner;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-21 14:27
 */

public class step53 {
    //TODO: Напишем программу для операций над очень большими числами от -9223372036854775808 до 9223372036854775807,
    //TODO: но добавим удаление лишних пробелов при вводе и возможность ввода только операций из списка:
    //TODO: abs, div, div_round, pow.

    public enum Operation {
        DIV,
        ABS,
        DIV_ROUND,
        POW
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String inputOne = getChoice("Введите первое число (для выхода введите end)", scanner);
            if ("end".equals(inputOne.toLowerCase())) {
                System.out.println("Программа завершена");
                break;
            }
            long value1 = Long.parseLong(inputOne);

            String inputTwo = getChoice("Введите второе число", scanner);
            long value2 = Long.parseLong(inputTwo);

            System.out.println("Выберите операцию abs, div, div_round, pow");
            try {
                Operation operation = Operation.valueOf(scanner.next().trim().toUpperCase());
                calculate(value1, value2, operation);
            } catch (Exception e) {
                System.out.println("Нет такой команды. Попробуйте еще раз. ");
                System.out.println(e.getMessage());
            }
            System.out.println("-----------------------------------------------");
        }
    }

    private static String getChoice(String str, Scanner scanner) {
        System.out.println(str);
        String input = scanner.next().trim();
        return input;
    }

    private static void calculate(long value1, long value2, Operation operation) {
        switch (operation) {
            case ABS:
                System.out.printf("value1 abs = %s %n", Math.abs(value1));
                System.out.printf("value2 abs = %s %n", Math.abs(value2));
                break;
            case DIV:
                System.out.printf("div = %s %n", (double) value1 / value2);
                break;
            case DIV_ROUND:
                System.out.printf("round div = %s %n", Math.round((double) value1 / value2));
                break;
            case POW:
                System.out.printf("pow = %s %n", Math.pow(value1, value2));
                break;
        }
    }
}
