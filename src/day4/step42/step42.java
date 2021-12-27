package day4.step42;

import java.util.Scanner;

import static day4.step42.IncomeExpense.prnMessage;
import static day4.step42.MainMenu.*;

public class step42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IncomeExpense incomeExpense = new IncomeExpense();
        boolean running = true;
        while (running) {
            switch (menuShow(5)) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    incomeExpense.setIncomeExpenseIncome(scanner.nextFloat());
                    prnMessage("Сумма дохода = ", incomeExpense.getIncomeExpenseIncome());
                    prnMessage("Сумма расхода = ", incomeExpense.getIncomeExpenseExpense());
                    prnMessage("");
                    prnMessage("");
                    break;
                case 2:
                    System.out.println("Введите сумму расходов:");
                    incomeExpense.setIncomeExpenseExpense(scanner.nextFloat());
                    prnMessage("Сумма дохода = ", incomeExpense.getIncomeExpenseIncome());
                    prnMessage("Сумма расхода = ", incomeExpense.getIncomeExpenseExpense());
                    prnMessage("");
                    prnMessage("");
                    break;
                case 3:
                    incomeExpense.checkTax();
                    prnMessage("");
                    prnMessage("");
                    break;
                case 4:
                    System.out.println("Программа завершена!");
                    running = false;
            }
/*            System.out.println("Сумма дохода = " + incomeExpense.getIncomeExpenseIncome());
            System.out.println("Сумма расхода = " + incomeExpense.getIncomeExpenseExpense());*/
        }
    }
}

