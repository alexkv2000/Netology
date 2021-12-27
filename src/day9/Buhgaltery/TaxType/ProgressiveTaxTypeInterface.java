package day9.Buhgaltery.TaxType;

import day9.Buhgaltery.TaxTypeInterface;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:17
 */
public class ProgressiveTaxTypeInterface implements TaxTypeInterface {
    public final int TAX_TEN = 10;
    public final int TAX_FIFTEEN = 15;
    public final int PROGRESS_SUM = 100000;

    @Override
    public double calculateTaxFor(double amount) {
        // TODO Прогрессивный налог, до 100 тысяч = 10%, больше 100 тысяч = 15% (ProgressiveTaxType)
        double sumProgress = 0;
        if (amount - 100000 > 0) { // если сумма больше 100000
            sumProgress = (amount - 100000) * TAX_FIFTEEN / 100;
            sumProgress += PROGRESS_SUM * TAX_TEN / 100;
        } else {
            sumProgress = amount * TAX_TEN / 100;
        }
        return sumProgress;
    }
}
