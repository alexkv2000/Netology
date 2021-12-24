package KAU.day7.Buhgaltery.Taxtype;

import KAU.day7.Buhgaltery.TaxType;

public class VATaxType implements TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        //TODO НДС, = 18% (VATaxType)
        return 0;
    }
}
