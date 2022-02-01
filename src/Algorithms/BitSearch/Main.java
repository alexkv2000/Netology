package Algorithms.BitSearch;

import java.util.Arrays;

public class Main {
    // В начале работы программы заведите массив со значениями: [14, 16, 19, 32, 32, 32, 56, 69, 72].
    // Напишите функцию, которая бы принимала массив, размер новой книги и возвращала бы количество больших по размеру
    // книг по рассмотренному выше алгоритму.
    //    Внимание! Вызывать готовые реализации бинарного поиска запрещено.
    // Вызовите эту функцию, передав туда массив и размер новой книги - 32. Выведите результат на экран.
    //    Убедитесь, что ответ верный: 3 (т.к. только три книги на полке строго больше чем 32 страницы).
    // Вызовите эту функцию, передав туда массив и размер новой книги - 60. Выведите результат на экран.
    //    Убедитесь, что ответ верный: 2 (т.к. только две книги на полке строго больше чем 60 страницы).
    // Загрузите ваше решение на сайт repl.it, отправьте ссылку на него на проверку.

    public static void main(String[] args) {
        int[] array = {14, 16, 19, 32, 32, 56, 69, 72};
        Arrays.sort(array); // на всякий случай

        int sizeBook = 32;
        int sizeBookMore = searchBook(array, sizeBook);
        System.out.printf("кол-во книг на полке превышающих размер %s: %s%n", sizeBook, String.valueOf(sizeBookMore));
        consoleArray(array, true, sizeBook);
        sizeBook = 60;
        sizeBookMore = searchBook(array, sizeBook);
        System.out.printf("кол-во книг на полке превышающих размер %s: %s%n", sizeBook, String.valueOf(sizeBookMore));
        consoleArray(array, true, sizeBook);
    }

    private static void consoleArray(int[] array, boolean separate, int sizeBook) {
        final String ANSI_SCARLET = "\u001b[31m";
        final String ANSI_RESET = "\u001B[0m";
        for (int i = 0; i < array.length; i++) {
            if (separate) {
                if (sizeBook < array[i])
                    System.out.print(ANSI_SCARLET + array[i] + ANSI_RESET + " ");
                else System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    private static int searchBook(int[] array, int sizeBook) {
        int count = 0;
        int left = 0;
        int right = array.length;
        int middle;
        while (right > left) {
            middle = left + (right - left) / 2;
            if (array[middle] > sizeBook) {
                right = middle;
            } else if (array[middle] <= sizeBook) {
                left = middle + 1;
            }
            ++count;
        }
        System.out.print("кол-во итераций : " + count + ". \n");
        return array.length - right;
    }
}
