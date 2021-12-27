package day9.Buhgaltery;

import day9.Buhgaltery.TaxType.IncomeTaxTypeInterface;
import day9.Buhgaltery.TaxType.ProgressiveTaxTypeInterface;
import day9.Buhgaltery.TaxType.VATaxTypeInterface;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-27 15:11
 */

public class Main {

    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        Bill[] payments = new Bill[]{
                // TODO создать платежи с различным типами налогообложения
                new Bill(100000, new IncomeTaxTypeInterface(), new TaxService()),
                new Bill(100550, new ProgressiveTaxTypeInterface(), new TaxService()),
                new Bill(100000, new VATaxTypeInterface(), new TaxService())
        };

        for (int i = 0; i < payments.length; ++i) {
            Bill bill = payments[i];
            bill.payTaxes();
        }
    }
}
