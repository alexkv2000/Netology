package day9.Buhgaltery.BuhgalteryBigData.TaxtypeBigData;

import day9.Buhgaltery.BuhgalteryBigData.TaxTypeBigData;

import java.math.BigDecimal;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:40
 */
public class IncomeTaxTypeBigData implements TaxTypeBigData {

    public final BigDecimal TAX_THIRTEEN = BigDecimal.valueOf(13);

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        // TODO Подоходный налог, = 13% (IncomeTaxType)
        return amount.multiply(TAX_THIRTEEN).divide(BigDecimal.valueOf(100)); //amount * TAX_THIRTEEN / 100;
    }
}
