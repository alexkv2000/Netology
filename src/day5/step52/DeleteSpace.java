package day5.step52;

import java.util.Scanner;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-21 13:43
 */
public class DeleteSpace {
    //TODO: написать метод, который будет принимать на вход строку, введенную пользователем,
    //TODO: и возвращать обработанную строку без лишних пробелов.
    //TODO: Результат выполнения нужно вывести в консоль.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст :"); // "  Текст с   большим количеством    пробелов !  "
        String string = scanner.nextLine();

        String result = extraTrim(string);
        System.out.println("Отформатированная строка:");
        System.out.println(result);
    }

    private static String extraTrim(String string) {
        String result = string.replaceAll("[\\s|\\u00A0]+", " ").trim(); // \u00A0 - неразрывный пробел
        return result;
    }
}
