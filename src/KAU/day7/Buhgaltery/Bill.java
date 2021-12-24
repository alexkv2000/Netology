package KAU.day7.Buhgaltery;

public class Bill {
    private double amount; //сумма прибыли
    private TaxType taxType; //тип налога из TaxType
    private TaxService taxService; //сумма налога

    public Bill(double amount, TaxType taxType, TaxService taxService) {
        this.amount = amount;
        this.taxType = taxType;
        this.taxService = taxService;
    }

    public void payTaxes() {
        // TODO вместо 0.0 посчитать размер налога исходя из TaxType
        // double taxAmount = 0.0;
        double taxAmount = taxType.calculateTaxFor(amount);
        taxService.payOut(amount, taxAmount, taxType);

    }

}
