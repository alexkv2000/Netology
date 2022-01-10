package day12.DynamicAccount;

import java.math.BigDecimal;

public class Transaction {
    Account accountFrom; // (с какого счета осуществляется перевод)
    Account accountTo; // (на какой счет осуществляется перевод)
    BigDecimal amount; // (сумма перевода)

    public boolean make() {
        // метод будет выполнять транзакцию, переводить деньги с одного счета на другой и в случае если это не возможно,
        // выводить ошибку выполнения транзакции
        accountFrom.setAmount(accountFrom.getAmount().subtract(amount));
        if (accountFrom.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            accountFrom.setAmount(accountFrom.getAmount().add(amount));
            return false;
        }
        accountTo.setAmount(accountTo.getAmount().add(amount));
        return true;
    }

    public Transaction(Account accountFrom, Account accountTo, BigDecimal amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("со счета: %s, на счет: %s, сумма: %.2f", accountFrom.getNumber(), accountTo.getNumber(), amount);
    }
}
