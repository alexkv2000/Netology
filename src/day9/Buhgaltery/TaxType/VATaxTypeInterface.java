package day9.Buhgaltery.TaxType;

import day9.Buhgaltery.TaxTypeInterface;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:17
 */
public class VATaxTypeInterface implements TaxTypeInterface {
    public final int TAX_EIGHTEEN = 18;

    @Override
    public double calculateTaxFor(double amount) {
        //TODO НДС, = 18% (VATaxType)
        return amount * TAX_EIGHTEEN / 100;
    }
}
