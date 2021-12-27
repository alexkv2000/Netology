package day9.Buhgaltery.TaxType;

import day9.Buhgaltery.TaxTypeInterface;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:16
 */
public class IncomeTaxTypeInterface implements TaxTypeInterface {

    public final int TAX_THIRTEEN = 13;

    @Override
    public double calculateTaxFor(double amount) {
        // TODO Подоходный налог, = 13% (IncomeTaxType)
        return amount * TAX_THIRTEEN / 100;
    }
}
