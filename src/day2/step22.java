package day2;

import java.util.Scanner;

public class step22 {
    public static final double PI = 3.1415926535;

    public static void main(String[] args) {

        System.out.println("Расчет площади круга и длины его окружности");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите радиус окружности в сантиметрах (Маска: %%,%%):");
        double radius = scanner.nextDouble();

        double area = calculateCircleArea(radius);
        double length = calculateCircleLength(radius);

        System.out.println("Площадь круга: " + String.format("%.3f", area) + " см.кв.");
        System.out.println("Длина окружности: " + String.format("%.3f", length) + " см.");
    }

    private static double calculateCircleLength(double radius) {
        radius = 2 * PI * radius;
        return radius;
    }

    public static double calculateCircleArea(double radius) {
        radius = PI * radius * radius;
        return radius;
    }

}
