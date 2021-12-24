package KAU.day7.BuhgalteryBigData;

import KAU.day7.BuhgalteryBigData.TaxtypeBigData.IncomeTaxTypeBigData;
import KAU.day7.BuhgalteryBigData.TaxtypeBigData.ProgressiveTaxTypeBigData;
import KAU.day7.BuhgalteryBigData.TaxtypeBigData.VATaxTypeBigData;

import java.math.BigDecimal;

public class MainBigData {

    public static void main(String[] args) {
        TaxServiceBigData taxService = new TaxServiceBigData();
        BillBigData[] payments = new BillBigData[]{
                // TODO создать платежи с различным типами налогообложения
                new BillBigData(new BigDecimal("100000"), new IncomeTaxTypeBigData(), new TaxServiceBigData()),
                new BillBigData(new BigDecimal("100550"), new ProgressiveTaxTypeBigData(), new TaxServiceBigData()),
                new BillBigData(new BigDecimal("100000"), new VATaxTypeBigData(), new TaxServiceBigData())
        };

        for (int i = 0; i < payments.length; ++i) {
            BillBigData bill = payments[i];
            bill.payTaxes();
        }
    }
}
