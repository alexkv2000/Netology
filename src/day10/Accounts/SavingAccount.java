package day10.Accounts;

public class SavingAccount extends Account {//Сберигательный счет
    int balance;

    public SavingAccount() {
        this.balance = 0;
    }

    //TODO Нельзя платить, Нельзя уходить в минус
    //TODO скрыть метод! не нужен
    @Override
    void pay(int amount) { //оплата на сумму - Нельзя платить!
        System.out.println("Данная операция не доступна для этого вида счета");
    }

    @Override
    void transfer(Account account, int amount) { //перевод со счета сумму
        if (isBalance(amount) && account.isBalanceAdd(amount)) {
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
    public String toString() {
        return "Сберегательный счет{" +
                "balance=" + balance +
                '}';
    }

    @Override
    public boolean isBalanceAdd(int amount) {
        return true;
    }

    public boolean isBalance(int amount) {
        return (this.balance - amount) >= 0;
    }
}
