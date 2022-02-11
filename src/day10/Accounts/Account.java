package day10.Accounts;

public abstract class Account {

    abstract void pay(int amount);

    abstract void transfer(Account account, int amount); //перевод со счета сумму

    abstract void addMoney(int amount); //пополнение суммы

    abstract boolean isBalanceAdd(int amount); //проверка возможности перевода

    public static void main(String[] args) {
        Account chechingAccount = new ChechingAccount();
        Account savingAccount = new SavingAccount();
        Account creditAccount = new CreditAccount();
        //---------------------------
        chechingAccount.addMoney(15_000);
        chechingAccount.transfer(savingAccount, 10_000);
        creditAccount.pay(3000);
        chechingAccount.transfer(creditAccount, 2_000);
        creditAccount.addMoney(1000);
        savingAccount.addMoney(10000);
        chechingAccount.addMoney(4000);
        chechingAccount.transfer(savingAccount, 7000);

        System.out.println(chechingAccount);
        System.out.println(savingAccount);
        System.out.println(creditAccount);

    }
}
