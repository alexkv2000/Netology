package KAU.day7.Buhgaltery.Taxtype;

import KAU.day7.Buhgaltery.TaxType;

public class IncomeTaxType implements TaxType {

    public final int TAX_THIRTEEN = 13;

    @Override
    public double calculateTaxFor(double amount) {
        // TODO Подоходный налог, = 13% (IncomeTaxType)
        return amount * TAX_THIRTEEN / 100;
    }
}
