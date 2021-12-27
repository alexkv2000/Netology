package day2;

import java.util.Scanner;

class step21 {
    public static void main(String[] args) {
        System.out.println("Подсчет суммы 3х Целых чисел. Операция суммирования уже считанных чисел должна быть вынесена в отдельный метод.");
        Scanner scanner = new Scanner(System.in);

        int val[] = new int[3];
        for (int i = 0; i <= 2; i++) {
            System.out.println("Введите " + (i + 1) + " значение суммы :");
            val[i] = scanner.nextInt();
        }
        System.out.println("Сумма чисел = " + sum(val));

    }

    public static int sum(int[] value) {
        int result = 0;
        for (int element : value) {
            result += element;
        }
        return result;
    }
}
