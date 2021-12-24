package KAU.day7.Buhgaltery.Taxtype;

import KAU.day7.Buhgaltery.TaxType;

public class VATaxType implements TaxType {
    public final int TAX_EIGHTEEN = 18;

    @Override
    public double calculateTaxFor(double amount) {
        //TODO НДС, = 18% (VATaxType)
        return amount * TAX_EIGHTEEN / 100;
    }
}
