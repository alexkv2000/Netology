package day12.CollectionList;

import java.util.Scanner;

public class MainMenu extends Exception {

    public static int menuShow(int col) {
        boolean flag = false;
        int choiceMainMenu = -1;
        while (!flag) {
            if (choiceMainMenu == -1) {
                System.out.println("Выбирите пункт меню :");
                mainMenuShow(col);
                choiceMainMenu = mainMenuChoice(col);
            } else {
                flag = true;
            }
        }
        return choiceMainMenu;
    }

    private static void mainMenuShow(int colPointsMenuShow) {
        String[] myStringArray = {
                "1. Добавить задачу",
                "2. Вывести список задач",
                "3. Удалить задачу",
                "__________________________________",
                "0. Выход"};
        if (colPointsMenuShow > myStringArray.length) {
            colPointsMenuShow = myStringArray.length;
        }
        for (int i = 0; i < colPointsMenuShow; i++) {
            System.out.println(myStringArray[i]);
        }
    }

    private static int mainMenuChoice(int colPointsMenuShow) {
        Scanner scanner = new Scanner(System.in);
        try {
            int choiceMenu = scanner.nextInt();
            if (choiceMenu > colPointsMenuShow) {
                choiceMenu = -1;
            }
            return choiceMenu;

        } catch (Exception e) {
            System.out.println("Ввели неверные данные - " + e.getMessage());
        }

        return -1;
    }
}

