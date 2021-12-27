package day8.step22;

import java.util.Random;
import java.util.Scanner;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-22 19:54
 */
public class MultidimensionalArray {
    public static int SIZE = 8;
    public static int[][] rotatedColors = new int[SIZE][SIZE]; //пустой массив для поворота
    public static int[][] colors = new int[SIZE][SIZE];

    public static void main(String[] args) {
       Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        showArray(SIZE, colors);

        System.out.println();
        System.out.println("На какой угол нужно повернуть Матрицу? (90/180/270/360)");
        choosRotation(colors);
    }

    private static void choosRotation(int[][] colors) {
        Scanner scanner = new Scanner(System.in);
        int coner = scanner.nextInt();
        switch (coner) {
            case 90:
                rotate90(SIZE, colors);
                break;
            case 180: {
                rotate90(SIZE, colors);
                copyMatrix(SIZE, rotatedColors, colors);
                rotate90(SIZE, colors);
                break;
            }
            case 270: {
                rotate90(SIZE, colors);
                copyMatrix(SIZE, rotatedColors, colors);
                rotate90(SIZE, colors);
                copyMatrix(SIZE, rotatedColors, colors);
                rotate90(SIZE, colors);
            }
            case 360: {
                copyMatrix(SIZE, colors, rotatedColors);
                break;
            }
            default: {
                System.out.println("Массив можно повернуть только на указанный угол");
            }

        }
//        rotate90(SIZE, colors);
        showArray(SIZE, rotatedColors);
    }

    private static void copyMatrix(int size, int[][] rotatedColors, int[][] colors) {
        System.arraycopy(rotatedColors, 0, colors, 0, size);
    }

    private static void rotate90(int SIZE, int[][] colors) {
        for (int i = 0; i < SIZE / 2; i++) {
            for (int j = i; j < SIZE - i - 1; j++) {
                int temp = colors[i][j];
                rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                rotatedColors[SIZE - 1 - j][i] = colors[SIZE - 1 - i][SIZE - 1 - j];
                rotatedColors[SIZE - 1 - i][SIZE - 1 - j] = colors[j][SIZE - 1 - i];
                rotatedColors[j][SIZE - 1 - i] = temp;
            }
        }
    }

    private static void showArray(int SIZE, int[][] colors) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // %4d означает, что мы под каждый номер резервируем 4 знака
                // (незанятые будут заполнены пробелами)
                // таким образом, у нас получится ровная таблица
                System.out.printf("%4d", colors[i][j]);
            }
            // Переход на следующую строку
            System.out.println();
        }
    }
}
