package day7.step21;

import java.util.Scanner;

import static day7.step21.AnsiColor.ANSI_RED;
import static day7.step21.AnsiColor.ANSI_RESET;

/**
 * KAU
 * Netology
 * 2021-12-22 18:17
 */
public class OneArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numArray = 4;

        String[] names = new String[numArray];
        names[0] = "Молоко";
        names[1] = "Рис";
        names[2] = "Крупа гречневая";
        names[3] = "Хлеб";

        int[] prices = new int[numArray];
        prices[0] = 45;
        prices[1] = 40;
        prices[2] = 54;
        prices[3] = 28;

        int[] choices = new int[numArray];

        listOfProducts(names, prices); //список продуктов - вывод экран

        while (true) {
            separateStr("Выберите товар и количество или введите `end`");
            System.out.print("Выбор продукта: ");

            try {
                String str = scanner.nextLine();
                if (str.equalsIgnoreCase("end") || str.equalsIgnoreCase("утв")) {
                    separateStr("Пользователь вышел из программы...");
                    break;
                }
                String[] tempArray = str.split(" ");
                int nTovar = Integer.parseInt(tempArray[0]);
                int conunt = Integer.parseInt(tempArray[1]);

                choices[nTovar - 1] += conunt;
                System.out.println(str + "  " + conunt);
                enterReceipt(names, prices, choices);
                listOfProducts(names, prices); //список продуктов - вывод экран
            } catch (ArrayIndexOutOfBoundsException eOut) {
                System.out.println(ANSI_RED + "выбранного товара нет" + ANSI_RESET);
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Ввели неверные данные" + ANSI_RESET);
            }
        }
        enterReceipt(names, prices, choices);
    }

    private static void listOfProducts(String[] names, int[] prices) {
        separateStr("Список продуктов :");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%3s. %-20s %5s руб/шт %n", i + 1, names[i], prices[i]);
        }
    }

    private static void enterReceipt(String[] names, int[] prices, int[] choices) {
        separateStr();
        separateStr("                        Ваша корзина");
        separateStr();
        separateStr("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
        int sum = 0;
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] != 0) {
                sum += (choices[i] * prices[i]);
                System.out.printf("%2s. %-17s %10s %11s %16s %n", i + 1, names[i], choices[i], prices[i], (choices[i] * prices[i]));
            }
        }
        separateStr();
        System.out.printf("Итого %55s %n", sum);
    }

    private static void separateStr(String str) {
        System.out.println(str);
    }

    private static void separateStr() {
        System.out.println("=".repeat(61));
    }

}
