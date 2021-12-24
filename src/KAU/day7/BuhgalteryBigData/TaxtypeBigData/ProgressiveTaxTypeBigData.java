package KAU.day7.BuhgalteryBigData.TaxtypeBigData;

import KAU.day7.BuhgalteryBigData.TaxTypeBigData;

import java.math.BigDecimal;

public class ProgressiveTaxTypeBigData implements TaxTypeBigData {
    public final BigDecimal TAX_TEN = BigDecimal.valueOf(10);
    public final BigDecimal TAX_FIFTEEN = BigDecimal.valueOf(15);
    public final BigDecimal PROGRESS_SUM = BigDecimal.valueOf(100000);

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        // TODO Прогрессивный налог, до 100 тысяч = 10%, больше 100 тысяч = 15% (ProgressiveTaxType)
        BigDecimal sumProgress = BigDecimal.valueOf(0);
        if (amount.subtract(BigDecimal.valueOf(100000)).intValue() > 0) { // если сумма больше 100000
            sumProgress = (amount.subtract(BigDecimal.valueOf(100000))).multiply(TAX_FIFTEEN).divide(BigDecimal.valueOf(100)).add(PROGRESS_SUM.multiply(TAX_TEN).divide(BigDecimal.valueOf(100)));
        } else {
            sumProgress = amount.multiply(TAX_TEN).divide(BigDecimal.valueOf(100));
        }
        //sumProgress+=(((amount % PROGRESS_SUM) * PROGRESS_SUM) * TAX_TEN / 100);
        //sumProgress+=(amount % PROGRESS_SUM) ;
        return sumProgress;
    }
}
