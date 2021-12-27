package day3;

import java.util.Scanner;

public class step32 {
    public static void main(String[] args) {
        System.out.println("Угадываем високосность");
        //TODO: это год, номер которого делится без остатка на 400 (например 2000 или 2400),
        //TODO: либо делится на 4 но не делится на 100 (например 2008, 2096, но не 2100).
        Scanner scanner = new Scanner(System.in);
        int count = 0; //счетчик верных ответов
        while (true) {
            System.out.print("Введите год в формате: YYYY количество-дней ");
            int year = scanner.nextInt();
            int days = scanner.nextInt();

            int calcDays = Integer.parseInt(highGradeYear(year));
            if (days == calcDays) {
                count++;
                System.out.println();
                System.out.println("Играем до первой ошибки.");
            } else {
                System.out.println("Неправильно! В этом году " + calcDays + " дней!");
                System.out.println("Набрано очков: " + count);
                break;
            }
        }
    }


    private static String highGradeYear(int year) {
        if (year % 400 == 0) {
            return "366";
        } else if (year % 100 == 0) {
            return "365";
        } else if (year % 4 == 0) {
            return "366";
        } else {
            return "365";
        }
    }
}
