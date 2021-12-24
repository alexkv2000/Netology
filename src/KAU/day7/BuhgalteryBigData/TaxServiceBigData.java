package KAU.day7.BuhgalteryBigData;

import java.math.BigDecimal;

public class TaxServiceBigData {
    public void payOut(BigDecimal amount, BigDecimal taxAmount, TaxTypeBigData taxType) {
        if(taxType.getClass().getSimpleName().equals("IncomeTaxTypeBigData")){
            System.out.printf("Подолходный налог от (%sр.), (13проц.) %n", amount);
        } else if(taxType.getClass().getSimpleName().equals("VATaxTypeBigData")){
            System.out.printf("Налог на добавленную стоимость от (%sр.), (НДС, - 18проц.) %n", amount);
        } else if(taxType.getClass().getSimpleName().equals("ProgressiveTaxTypeBigData")){
            System.out.printf("Прогрессивный налог от (%sр.), (до 100 тысяч - 10проц., больше 100 тысяч = 15проц.) %n", amount);
        }
        System.out.format("Уплачен в размере %.2f%n", taxAmount);
    }
}
