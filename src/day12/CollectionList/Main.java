package day12.CollectionList;

import java.util.ArrayList;
import java.util.Scanner;

import static day12.CollectionList.MainMenu.menuShow;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int choice = menuShow(5);
            switch (choice) {
                case (0):
                    flag = false;
                    break;
                case (1): {
                    System.out.println("Задача: ");
                    String str = scanner.nextLine();
                    list.add(str);
                    break;
                }
                case (2): {
                    if (!isListEmpty(list)) {
                        showList(list);
                    }
                    break;
                }
                case (3): {
                    if (!isListEmpty(list)) {
                        System.out.print("Введите номер удаляемой строки: ");
                        try {
                            list.remove(Integer.parseInt(scanner.nextLine()) - 1);
                        } catch (Exception e) {
                            System.out.println("Номер строки не существует -> " + e.getMessage());
                        }
                    }
                }
            }
        }
    }

    private static boolean isListEmpty(ArrayList<String> list) {
        if (list.size() == 0) {
            System.out.println("Список пуст!");
            return true;
        }
        return false;
    }

    private static void showList(ArrayList<String> list) {
        int i = 1;
        for (String aList : list) {
            System.out.println((i++) + ". " + aList);
        }
        System.out.println();
    }
}
