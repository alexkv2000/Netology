package day4.step42;

public class IncomeExpense {
    private float income; // income - доход
    private float expense; //expense - расход

    private static final String ANSI_RED = "\u001B[41m"; // подцветка разницы доход - расход - красный фон
    private static final String ANSI_RESET = "\u001B[0m"; // конец подцветки - черный фон

    IncomeExpense() {
        this.income = 0.0f;
        this.expense = 0.0f;
    }

    public float getIncomeExpenseIncome() {
        return this.income;
    }

    public float getIncomeExpenseExpense() {
        return this.expense;
    }

    public void setIncomeExpenseIncome(float income) {
        this.income += income;
    }

    public void setIncomeExpenseExpense(float expense) {
        this.expense += expense;
    }

    public void checkTax() {
        float taxIncome = (float) (getIncomeExpenseIncome() * .06);
        float taxIncomeExpense = (float) ((getIncomeExpenseIncome() - getIncomeExpenseExpense()) * .15);
        if (taxIncomeExpense < 0) {
            taxIncomeExpense = 0;
        }
        if (taxIncome < taxIncomeExpense) {
            prnMessage("Мы советуем вам \'УСН доходы\'");
            prnMessage("Ваш налог составит: ", taxIncome);
            prnMessage("Налог на другой системе: ", taxIncomeExpense);
            prnMessage(ANSI_RED + "Экономия: ", (taxIncomeExpense - taxIncome));
        } else {
            prnMessage("Мы советуем вам \'УСН доходы минус расходы\'");
            prnMessage("Ваш налог составит: ", taxIncomeExpense);
            prnMessage("Налог на другой системе: ", taxIncome);
            prnMessage(ANSI_RED + "Экономия: ", (taxIncome - taxIncomeExpense));
        }
    }

    public static void prnMessage(String message, float sum) {

        System.out.println(message + sum + " р."+ ANSI_RESET);
    }

    public static void prnMessage(String message) {
        System.out.println(message);
    }
}
