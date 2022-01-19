package day14.Menu;

import java.util.Scanner;

public class Main extends Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleMenu mainMenu = new ConsoleMenu();
        mainMenu.setNameMenu(new Menu("1. ", "Add", "ADD"));
        mainMenu.setNameMenu(new Menu("2. ", "Delete", "DELETE"));
        mainMenu.setNameMenu(new Menu("3. ", "Show", "SHOW"));
        mainMenu.setNameMenu(new Menu("0. ", "Exit", "EXIT"));

        ConsoleMenu productMenu = new ConsoleMenu();
        productMenu.setNameMenu(new Menu(" 1. ", "Onion", "SHOWONION"));
        productMenu.setNameMenu(new Menu(" 2. ", "Carrot", "SHOWCARROT"));
        productMenu.setNameMenu(new Menu(" 3. ", "Tomato", "SHOW_TOMATO"));
        productMenu.setNameMenu(new Menu(" 0. ", "Return", "RETURN"));

        ConsoleMenu showMenu = mainMenu;
        boolean flag = false;
        while (!flag) {
            showMenu.listNameMenu();
            try {
                int choiceMenu = Integer.parseInt(scanner.nextLine());
                if (showMenu.getCount() <= choiceMenu) {
                    throw new MyException();
                }
                if (choiceMenu == 0) {
                    choiceMenu = 4;
                }
                switch (showMenu.getMenuCommand(choiceMenu - 1)) {
                    case ("ADD"): {
                        System.out.println("Choice 1 " + showMenu.getMenuCommand(0));
                        showMenu = productMenu;
                        break;
                    }
                    case ("DELETE"): {
                        System.out.println("Choice 2 " + showMenu.getMenuCommand(1));
                        break;
                    }
                    case ("SHOW"): {
                        System.out.println("Choice 3 " + showMenu.getMenuCommand(2));
                        break;
                    }
                    case ("EXIT"): {
                        System.out.println("Choice 0 " + showMenu.getMenuCommand(3));
                        flag = true;
                        break;
                    }
                    case ("SHOWONION"): {
                        System.out.println("Choice 1 " + showMenu.getMenuCommand(0));
                        break;
                    }
                    case ("SHOWCARROT"): {
                        System.out.println("Choice 2 " + showMenu.getMenuCommand(1));
                        break;
                    }
                    case ("SHOW_TOMATO"): {
                        System.out.println("Choice 3 " + showMenu.getMenuCommand(2));
                        break;
                    }
                    case ("RETURN"): {
                        System.out.println("Choice 0 " + showMenu.getMenuCommand(3));
                        showMenu = mainMenu;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Формат вводе не верный");
            } catch (MyException e) {
                System.out.println("Данные ввода не верные");
            }
        }
    }
}
