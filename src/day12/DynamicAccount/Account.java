package day12.DynamicAccount;

import java.math.BigDecimal;

public class Account {
    String number; //(номер)
    String owner; // (владелец)
    BigDecimal amount; // (сумма на счете)

    public Account(String number, String owner, BigDecimal amount) {
        this.number = number;
        this.owner = owner;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Счет номер: %s, владелец: %s, сумма: %s", number, owner, amount);
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return this.number;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}


