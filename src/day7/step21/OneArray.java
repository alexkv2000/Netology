package day7.step21;

import java.util.Scanner;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 18:17
 */
public class OneArray {
    public static void main(String[] args) {
        Integer numArray = 4;

        String[] names = new String[numArray];
        names[0] = "Молоко";
        names[1] = "Рис";
        names[2] = "Крупа гречневая";
        names[3] = "Хлеб";

        Integer[] prices = new Integer[numArray];
        prices[0] = 45;
        prices[1] = 40;
        prices[2] = 54;
        prices[3] = 28;

        Integer[] choices = new Integer[numArray];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = 0;
        }

        listOfProducts(names, prices); //список продуктов - вывод экран

        while (true) {
            SeparateStr("Выберите товар и количество или введите `end`");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if (str.equals("end")) {
                SeparateStr("Пользователь вышел из программы...");
                break;
            }
            int nTovar = Integer.parseInt(str);
            int conunt = Integer.parseInt(scanner.next());

            choices[nTovar - 1] += conunt;
            System.out.println(str + "  " + conunt);
            enterReceipt(names, prices, choices);
            listOfProducts(names, prices); //список продуктов - вывод экран
        }
        enterReceipt(names, prices, choices);
    }

    private static void listOfProducts(String[] names, Integer[] prices) {
        SeparateStr("Список продуктов :");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%3s. %-20s %5s руб/шт %n", i + 1, names[i], prices[i]);
        }
    }

    private static void enterReceipt(String[] names, Integer[] prices, Integer[] choices) {
        SeparateStr();
        SeparateStr("                        Ваша корзина");
        SeparateStr();
        SeparateStr("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
        int sum = 0;
        for (int i = 0; i < choices.length; i++) {
            if(choices[i]!=0){
                sum += (choices[i] * prices[i]);
                System.out.printf("%2s. %-17s %10s %11s %16s %n",i+1, names[i], choices[i], prices[i], (choices[i] * prices[i]));
            }
        }
        SeparateStr();
        System.out.printf("Итого %55s %n",sum);
    }

    private static void SeparateStr(String str) {
        System.out.println(str);
    }

    private static void SeparateStr() {
        System.out.println("=".repeat(61));
    }

}
