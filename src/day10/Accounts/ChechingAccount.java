package day10.Accounts;

public class ChechingAccount extends Account {//Расчетный счет
    //TODO Расчетный счет - не может уходить в минус
    int balance;

    public ChechingAccount() {
        this.balance = 0;
    }

    @Override
    public String toString() {
        return "Расчетный счет{" +
                "balance=" + balance +
                '}';
    }

    @Override
    void pay(int amount) { //оплата на сумму
        if (isBalance(amount)) {
            balance -= amount;
        } else {
            System.out.println("На счете не достаточно средств.");
        }
    }

    @Override
    void transfer(Account account, int amount) { //перевод на другой счет сумму
        if (isBalance(amount) && account.isBalanceAdd(amount)) {
            //TODO интегрировать с счетами
            account.addMoney(amount);
            balance -= amount;
        } else {
            System.out.println("На счете не достаточно средств.");
        }
    }

    @Override
    void addMoney(int amount) { //пополнение суммы
        balance += amount;
    }

    @Override
    public boolean isBalanceAdd(int amount) {
        return true;
    }

    public boolean isBalance(int amount) {
        return (this.balance - amount) >= 0;
    }
}
