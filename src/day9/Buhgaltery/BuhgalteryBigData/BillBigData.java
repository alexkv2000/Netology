package day9.Buhgaltery.BuhgalteryBigData;

import java.math.BigDecimal;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:38
 */
public class BillBigData {
    private BigDecimal amount; //сумма прибыли
    private TaxTypeBigData taxType; //тип налога из TaxType
    private TaxServiceBigData taxService; //сумма налога

    public BillBigData(BigDecimal amount, TaxTypeBigData taxType, TaxServiceBigData taxService) {
        this.amount = amount;
        this.taxType = taxType;
        this.taxService = taxService;
    }

    public void payTaxes() {
        // TODO вместо 0.0 посчитать размер налога исходя из TaxType
        // double taxAmount = 0.0;
        BigDecimal taxAmount = taxType.calculateTaxFor(amount);
        taxService.payOut(amount, taxAmount, taxType);

    }

}