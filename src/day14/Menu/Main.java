package day14.Menu;

import java.util.Scanner;

public class Main extends Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleMenu mainMenu = new ConsoleMenu();
        mainMenu.setNameMenu(new Menu("1. ", "Add"));
        mainMenu.setNameMenu(new Menu("2. ", "Delete"));
        mainMenu.setNameMenu(new Menu("3. ", "Show"));
        mainMenu.setNameMenu(new Menu("----", "------------------"));
        mainMenu.setNameMenu(new Menu("0. ", "Exit"));
        //mainMenu.getNameMenu(); //отображение в консоль

        ConsoleMenu productMenu = new ConsoleMenu();
        productMenu.setNameMenu(new Menu(" 1. ", "Onion"));
        productMenu.setNameMenu(new Menu(" 2. ", "Carrot"));
        productMenu.setNameMenu(new Menu(" 3. ", "Tomato"));
        productMenu.setNameMenu(new Menu(" 0. ", "Return"));

        ConsoleMenu showMenu = mainMenu;
        boolean flag = false;
        while (!flag) {
            showMenu.getNameMenu();
            try {
                int choiceMenu = Integer.parseInt(scanner.nextLine());
                if (showMenu.getCount() < choiceMenu) {
                    throw new MyException();
                }
                if (choiceMenu == showMenu.getMenuNumber(1) - 1) {
                    System.out.println("Choice 1");
                    showMenu = productMenu;
                } else if (choiceMenu == showMenu.getMenuNumber(2) - 1) {
                    System.out.println("Choice 2");
                    showMenu = mainMenu;
                } else if (choiceMenu == showMenu.getMenuNumber(3) - 1) {
                    System.out.println("Choice 3");
                    showMenu = mainMenu;
                } else if (choiceMenu == showMenu.getMenuNumber(0)) {
                    System.out.println("Choice 0");
                    flag = true;
                }

            } catch (Exception e) {
                System.out.println("Error Choice number");
            } catch (MyException e) {
                System.out.println("!!!!!!!!!");
            }


        }

    }
}
