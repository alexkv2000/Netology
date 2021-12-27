package day9.Buhgaltery;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:14
 */
public class Bill {
    private double amount; //сумма прибыли
    private TaxTypeInterface taxType; //тип налога из TaxType
    private TaxService taxService; //сумма налога

    public Bill(double amount, TaxTypeInterface taxType, TaxService taxService) {
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
