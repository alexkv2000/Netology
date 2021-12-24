package KAU.day7.Buhgaltery.Taxtype;

import KAU.day7.Buhgaltery.TaxType;

public class IncomeTaxType implements TaxType {

    @Override
    public double calculateTaxFor(double amount) {
        // TODO Подоходный налог, = 13% (IncomeTaxType)
        return 0;
    }
}
