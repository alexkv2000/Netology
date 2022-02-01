package day8.step22;

import java.util.Scanner;

/**
 * KAU
 * Netology
 * 2021-12-22 20:52
 */
public class TicTacToe {

    public static final int SIZE = 4;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';
    int[][] i = new int[5][];


    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }

        Scanner scanner = new Scanner(System.in);

        boolean isCrossTurn = true;

        while (true) {
            printField(field);
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "! (координаты X, Y через пробел)");
            String input = scanner.nextLine(); // "2 3"
            String[] parts = input.split(" "); // ["2" , "3"]
            int r = Integer.parseInt(parts[0]) - 1; // 2-1 = 1
            int c = Integer.parseInt(parts[1]) - 1; // 3-1 = 2

            if (field[r][c] != EMPTY) {
                System.out.println("Сюда ходить нельзя");
                continue;
            }

            field[r][c] = isCrossTurn ? CROSS : ZERO;
            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                printField(field);
                System.out.println("Победили " + (isCrossTurn ? "крестики" : "нолики"));
                break;
            } else {
                if (isCrossTurn) {
                    isCrossTurn = false;
                } else {
                    isCrossTurn = true;
                }
                //isCrossTurn = !isCrossTurn;
            }
        }

        System.out.println("Игра закончена!");
    }

    // !!ВНИМАНИЕ!!
    // Работает только для 3x3
    // Этот метод вам и надо переписать
    public static boolean isWin(char[][] field, char player) {
        boolean flag = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == player) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            } else {
                break;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] == player) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            } else {
                break;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (field[i][i] == player) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }

        for (int i = 0; i < SIZE; i++) {
            if (field[SIZE - 1 - i][i] == player) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        } else {
            return false;
        }

    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}


