package day9.Buhgaltery.BuhgalteryBigData.TaxtypeBigData;

import day9.Buhgaltery.BuhgalteryBigData.TaxTypeBigData;

import java.math.BigDecimal;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:39
 */
public class VATaxTypeBigData implements TaxTypeBigData {
    public final BigDecimal TAX_EIGHTEEN = BigDecimal.valueOf(18);

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        //TODO НДС, = 18% (VATaxType)
        return amount.multiply(TAX_EIGHTEEN).divide(BigDecimal.valueOf(100));
    }
}
