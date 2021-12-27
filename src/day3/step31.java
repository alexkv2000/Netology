package day3;

import java.util.Scanner;

public class step31 {
    public static void main(String[] args) {
        System.out.println("Високосный год");
        //TODO: это год, номер которого делится без остатка на 400 (например 2000 или 2400),
        //TODO: либо делится на 4 но не делится на 100 (например 2008, 2096, но не 2100).
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите год в формате YYYY : ");
            int year = scanner.nextInt();

            System.out.println("Количество дней " + highGradeYear(year));

            System.out.println("Для выхода нажмите \'N\' ");
            String exit = scanner.nextLine();
            exit = scanner.nextLine();
            if (exit.toUpperCase().equals("N"))  {
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
