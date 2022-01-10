package day12.CollectionQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new LinkedList();
        while (true) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            int floor = scanner.nextInt();
            if (floor == 0) {
                queue.add(floor);
                showList(queue);
                break;
            } else if (floor > 26 || floor < 0) {
                System.out.println("Такого этажа нет в доме");
            } else {
                queue.add(floor);
            }
        }
    }

    private static void showList(Queue queue) {
        String str = "";
        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (!element.equals(0)) {
                if (!str.equals("")) {
                    str += " -> ";
                }
                str += "Этаж " + element;
            } else if (element.equals(0)) {
                str += " Этаж - " + element;

            }

        }
        System.out.printf("Лифт проследовал по следующим этажам:\n%s", str);

    }
}
