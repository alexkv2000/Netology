package KAU.day7.BuhgalteryBigData.TaxtypeBigData;

import KAU.day7.BuhgalteryBigData.TaxTypeBigData;

import java.math.BigDecimal;

public class VATaxTypeBigData implements TaxTypeBigData {
    public final BigDecimal TAX_EIGHTEEN = BigDecimal.valueOf(18);

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        //TODO НДС, = 18% (VATaxType)
        return amount.multiply(TAX_EIGHTEEN).divide(BigDecimal.valueOf(100));
    }
}
