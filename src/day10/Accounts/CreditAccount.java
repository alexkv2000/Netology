package day10.Accounts;

public class CreditAccount extends Account {//Кредитный счет
    int balance;

    public CreditAccount() {
        this.balance = 0;
    }

    //TODO не может иметь положительный баланс!
    @Override
    void pay(int amount) { //оплата на сумму
        balance -= amount;
    }

    @Override
    void transfer(Account account, int amount) { //перевод со счета сумму
        if (isBalanceAdd(amount) && account.isBalanceAdd(amount)) {
            account.addMoney(amount);
            balance -= amount;
        }
    }

    @Override
    void addMoney(int amount) { //пополнение суммы
        if (isBalanceAdd(amount)) {
            balance += amount;
        } else {
            System.out.println("Сумма к погашению превышает задолженность.");
        }
    }

    @Override
    public String toString() {
        return "Кредитный счет{" +
                "balance=" + balance +
                '}';
    }

    @Override
    public boolean isBalanceAdd(int amount) {
        if (this.balance + amount <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
