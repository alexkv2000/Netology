package day4;

import java.util.Scanner;

import static day4.s42.IncomeExpense.prnMessage;


public class s42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IncomeExpense incomeExpense = new IncomeExpense();
        boolean running = true;
        while (running) {
            switch (MainMenu.menuShow(5)) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    incomeExpense.setIncomeExpenseIncome(scanner.nextFloat());
                    prnMessage("Сумма дохода = ", IncomeExpense.getIncomeExpenseIncome());
                    prnMessage("Сумма расхода = ", IncomeExpense.getIncomeExpenseExpense());
                    prnMessage("");
                    prnMessage("");
                    break;
                case 2:
                    System.out.println("Введите сумму расходов:");
                    incomeExpense.setIncomeExpenseExpense(scanner.nextFloat());
                    prnMessage("Сумма дохода = ", IncomeExpense.getIncomeExpenseIncome());
                    prnMessage("Сумма расхода = ", IncomeExpense.getIncomeExpenseExpense());
                    prnMessage("");
                    prnMessage("");
                    break;
                case 3:
                    IncomeExpense.checkTax();
                    prnMessage("");
                    prnMessage("");
                    break;
                case 4:
                    System.out.println("Программа завершена!");
                    running = false;
            }
        }
    }

    public static class MainMenu {
        public static int menuShow(int col) {
            boolean flag = false;
            int choiceMainMenu = 0;
            while (!flag) {
                if (choiceMainMenu == 0) {
                    System.out.println("Выбирите пункт меню :");
                    mainMenuShow(col);
                    choiceMainMenu = MainMenu.mainMenuChoice(col);
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

    public static class IncomeExpense {
        private static float income; // income - доход
        private static float expense; //expense - расход

        private static final String ANSI_RED = "\u001B[41m"; // подцветка разницы доход - расход - красный фон
        private static final String ANSI_RESET = "\u001B[0m"; // конец подцветки - черный фон

        IncomeExpense() {
            income = 0.0f;
            expense = 0.0f;
        }

        public static float getIncomeExpenseIncome() {
            return income;
        }

        public static float getIncomeExpenseExpense() {
            return expense;
        }

        public void setIncomeExpenseIncome(float income) {
            IncomeExpense.income += income;
        }

        public void setIncomeExpenseExpense(float expense) {
            IncomeExpense.expense += expense;
        }

        public static void checkTax() {
            float taxIncome = (float) (IncomeExpense.getIncomeExpenseIncome() * .06);
            float taxIncomeExpense = (float) ((IncomeExpense.getIncomeExpenseIncome() - IncomeExpense.getIncomeExpenseExpense()) * .15);
            if (taxIncomeExpense < 0) {
                taxIncomeExpense = 0;
            }
            if (taxIncome < taxIncomeExpense) {
                prnMessage("Мы советуем вам 'УСН доходы'");
                prnMessage("Ваш налог составит: ", taxIncome);
                prnMessage("Налог на другой системе: ", taxIncomeExpense);
                prnMessage(ANSI_RED + "Экономия: ", (taxIncomeExpense - taxIncome));
            } else {
                prnMessage("Мы советуем вам 'УСН доходы минус расходы'");
                prnMessage("Ваш налог составит: ", taxIncomeExpense);
                prnMessage("Налог на другой системе: ", taxIncome);
                prnMessage(ANSI_RED + "Экономия: ", (taxIncome - taxIncomeExpense));
            }
        }

        public static void prnMessage(String message, float sum) {

            System.out.println(message + sum + " р." + ANSI_RESET);
        }

        public static void prnMessage(String message) {
            System.out.println(message);
        }
    }
}


