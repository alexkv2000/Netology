package day9.Buhgaltery;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:14
 */
public class TaxService {
    public void payOut(double amount, double taxAmount, TaxTypeInterface taxType) {
        if(taxType.getClass().getSimpleName().equals("IncomeTaxTypeInterface")){
            System.out.printf("Подолходный налог от (%sр.), (13проц.) %n", amount);
        } else if(taxType.getClass().getSimpleName().equals("VATaxTypeInterface")){
            System.out.printf("Налог на добавленную стоимость от (%sр.), (НДС, - 18проц.) %n", amount);
        } else if(taxType.getClass().getSimpleName().equals("ProgressiveTaxTypeInterface")){
            System.out.printf("Прогрессивный налог от (%sр.), (до 100 тысяч - 10проц., больше 100 тысяч = 15проц.) %n", amount);
        }
        System.out.format("Уплачен в размере %.2f%n", taxAmount);
    }
}