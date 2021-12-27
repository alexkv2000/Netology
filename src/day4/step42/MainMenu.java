package day4.step42;

import java.util.Scanner;

public class MainMenu {

    public static int menuShow(int col) {
        boolean flag = false;
        int choiceMainMenu = 0;
        while (!flag) {
            if (choiceMainMenu == 0) {
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
                "1. Добавить новый доход",
                "2. Добавить новый расход",
                "3. Выбрать систему налогооблажения",
                "__________________________________",
                "4. Выход"};
        if (colPointsMenuShow > myStringArray.length) {
            colPointsMenuShow = myStringArray.length;
        }
        for (int i = 0; i < colPointsMenuShow; i++) {
            System.out.println(myStringArray[i]);
        }
    }

    private static int mainMenuChoice(int colPointsMenuShow) {
        Scanner scanner = new Scanner(System.in);
        int choiceMenu = scanner.nextInt();
        if (choiceMenu > colPointsMenuShow) {
            choiceMenu = -1;
        }
        return choiceMenu;
    }
}
