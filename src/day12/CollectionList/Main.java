package day12.CollectionList;

import java.util.ArrayList;
import java.util.Scanner;

import static day12.CollectionList.MainMenu.menuShow;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = menuShow(5);
            //        System.out.println(choice);
            if (choice == 0) {
                break;
            } else if (choice == 1) { // 1. Добавить задачу
                System.out.println("Задача: ");
                String str = scanner.nextLine();
                list.add(str);
            } else if (choice == 2) { // 2. Вывести список задач
                System.out.println();
                showList(list);
            } else if (choice == 3) { //3. Удалить задачу
                System.out.print("Введите номер удаляемой строки: ");
                try {
                    list.remove(Integer.parseInt(scanner.nextLine()) - 1);
                } catch (Exception e) {
                    System.out.println("Номер строки не существует" + e.getMessage());
                }
            }
        }
    }

    private static void showList(ArrayList<String> list) {
        int i = 1;
        for (String aList : list) {
            System.out.println((i++) + ". " + aList);
        }
        System.out.println();
    }
}
