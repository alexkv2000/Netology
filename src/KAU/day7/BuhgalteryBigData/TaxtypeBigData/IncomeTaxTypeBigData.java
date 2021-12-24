package KAU.day7.BuhgalteryBigData.TaxtypeBigData;

import KAU.day7.BuhgalteryBigData.TaxTypeBigData;

import java.math.BigDecimal;

public class IncomeTaxTypeBigData implements TaxTypeBigData {

    public final BigDecimal TAX_THIRTEEN = BigDecimal.valueOf(13);

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        // TODO Подоходный налог, = 13% (IncomeTaxType)
        return amount.multiply(TAX_THIRTEEN).divide(BigDecimal.valueOf(100)); //amount * TAX_THIRTEEN / 100;
    }
}
