package br.com.ilegra.batchdataanalyzer.extractor;

import br.com.ilegra.batchdataanalyzer.bean.Bean;
import br.com.ilegra.batchdataanalyzer.bean.SaleItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class SaleItemExtractor implements Extractor{

    private final static int TYPE_ID_INDEX = 0;
    private final static int AMOUNT = 1;
    private final static int PRICE = 2;

    @Override
    public Bean extract(List<String> saleItemData) {
        Bean saleItem  = new SaleItem(
                saleItemData.get(TYPE_ID_INDEX),
                Long.valueOf(saleItemData.get(AMOUNT)),
                new BigDecimal(saleItemData.get(PRICE).replace(",",".")));

        return saleItem;
    }
}
