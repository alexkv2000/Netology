package day12.CollectionQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int maxFloor = 25;
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList();
        while (true) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            try {
                int floor = scanner.nextInt();
                if (floor == 0) {
                    queue.offer(floor);
                    console(queue);
                    break;
                } else if (floor > maxFloor || floor < 0) {
                    System.out.println("Такого этажа нет в доме");
                } else {
                    queue.add(floor);
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода, " + e + ". Программа закрыта.");
                break;
            }
        }
    }

    private static void console(Queue<Integer> queue) {
        StringBuilder str = new StringBuilder();
        str.append("Этаж " + queue.poll());
        while (!queue.isEmpty()) {
            if (queue.peek() != 0) {
                if (!str.equals("")) {
                    str.append(" -> ");
                }
                str.append("Этаж " + queue.poll());
            } else if (queue.peek() == 0) {
                str.append(" Этаж - " + queue.poll());
            }
        }
        System.out.printf("Лифт проследовал по следующим этажам:\n%s", str);
    }
}
