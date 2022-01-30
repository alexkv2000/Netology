package day8.step22;

import java.util.Random;
import java.util.Scanner;

import static day14.TreeMap.AnsiColor.ANSI_RESET;
import static day14.TreeMap.AnsiColor.ANSI_SCARLET;

/**
 * KAU
 * Netology
 * 2021-12-22 19:54
 */
public class MultidimensionalArray {
    public final static int SIZE = 5;
    public final static int[][] matrix = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        newArray(random);
        while (true) {
            System.out.printf("Матрица размерностью %sх%<s элементов\n", SIZE);
            System.out.println("На какой угол нужно повернуть Матрицу? (90/180/270/360) or Exit - 'End'");
            String corner = chooseRotation(scanner);
            if (corner.equalsIgnoreCase("end") || corner.equalsIgnoreCase("утв")) {
                break;
            }
            try {
                showArray(matrix);
                System.out.println();
                int[][] newMatrix = rotateCorner(Integer.parseInt(corner));
                showArray(newMatrix);
            } catch (Exception e) {
                System.out.println(ANSI_SCARLET + "ошибка ввода данных : " + ANSI_RESET + e.getMessage());
            }
        }
    }

    private static void newArray(Random random) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextInt(256);
            }
        }
    }

    private static String chooseRotation(Scanner scanner) {
        String corner = "";
        try {
            corner = scanner.nextLine();
            return corner;
        } catch (Exception e) {
            System.out.println(ANSI_SCARLET + "не корректные данные" + ANSI_RESET);
        }
        return corner;
    }

    private static int[][] rotateCorner(int corner) {
        switch (corner) {
            case 90: {
                return rotate90(MultidimensionalArray.matrix);
            }
            case 180: {
                return rotate90(rotate90(MultidimensionalArray.matrix));
            }
            case 270: {
                return rotate90(rotate90(rotate90(MultidimensionalArray.matrix)));
            }
            case 360: {
                return MultidimensionalArray.matrix;
            }
            default: {
                System.out.println(ANSI_SCARLET + "Массив можно повернуть только на указанный угол" + ANSI_RESET);
                return MultidimensionalArray.matrix;
            }
        }
    }

    private static int[][] rotate90(int[][] matrix) {
        int[][] matrixTemp = new int[SIZE][SIZE];
        for (int i = 0; i <= SIZE / 2; i++) {
            for (int j = i; j < SIZE - i - 1; j++) {
                int temp = matrix[i][j];
                matrixTemp[i][j] = matrix[SIZE - 1 - j][i];
                matrixTemp[SIZE - 1 - j][i] = matrix[SIZE - 1 - i][SIZE - 1 - j];
                matrixTemp[SIZE - 1 - i][SIZE - 1 - j] = matrix[j][SIZE - 1 - i];
                matrixTemp[j][SIZE - 1 - i] = temp;
            }
        }
        if (SIZE % 2 != 0) {
            matrixTemp[SIZE / 2][SIZE / 2] = matrix[SIZE / 2][SIZE / 2];
        }
        return matrixTemp;
    }

    private static void showArray(int[][] matrixShow) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    System.out.printf("%4d", matrixShow[i][j]);
                } catch (NullPointerException e) {
                    System.out.println("ошибка ввода : " + e.getMessage());
                    break;
                }

            }
            System.out.println();
        }
    }
}
