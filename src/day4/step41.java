package day4;

import java.util.Scanner;

public class step41 {
    //Сравнение double
    //TODO: сравнения double, float и округления этих типов

    public static void main(String[] args) {
        while (true) {
            printMenuChoice();
            Scanner scanner = new Scanner(System.in);
            short choice = scanner.nextShort();
            if (choice == 4) {
                System.out.println("Выход из программы ...");
                break;
            };
            if (choice == 1) {
                double dNum1 = getdNum("Введите первое число или \'n\' для вохода: ", scanner);
                System.out.print("Введите второе число : ");
                float dNum2 = scanner.nextFloat();

                System.out.println("Результат : ");
                resultCompare(dNum1, dNum2);

            } else if (choice == 2) {
                double dNum = getdNum("Введите число для округления: ", scanner);
                double roundNum = Math.round(dNum);
                System.out.println("Результат : ");
                System.out.printf("%.0f", roundNum);

            } else if (choice == 3) {
                double dNum = getdNum("Введите число (отбось дробную часть)): ", scanner);
                long roundNum = (long) dNum;
                System.out.println("Результат : ");
                System.out.println(roundNum);

            } else System.out.println("Выбран не верный пункт ");
        }
    }

    private static double getdNum(String s, Scanner scanner) {
        System.out.print(s);
        double dNum = scanner.nextDouble();
        return dNum;
    }

    private static void printMenuChoice() {
        System.out.println("\n1. Сравнить");
        System.out.println("2. Округлить");
        System.out.println("3. Отбросить дробную часть");
        System.out.println("4. Выход");
    }

    private static void resultCompare(double dNum1, float dNum2) {
        if (Math.abs((float) dNum1 - dNum2) <= 0.0001) {
            System.out.printf("Числа %f и %f равны", dNum1, dNum2);
        } else if ((float) dNum1 - dNum2 > 0) {
            System.out.printf("%f больше %f", dNum1, dNum2);
        } else {
            System.out.printf("%f меньше %f", dNum1, dNum2);
        }
    }
}
