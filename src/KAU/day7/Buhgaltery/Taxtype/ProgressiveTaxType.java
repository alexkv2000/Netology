package KAU.day7.Buhgaltery.Taxtype;

import KAU.day7.Buhgaltery.TaxType;

public class ProgressiveTaxType implements TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        // TODO Прогрессивный налог, до 100 тысяч = 10%, больше 100 тысяч = 15% (ProgressiveTaxType)
        return 0;
    }
}
