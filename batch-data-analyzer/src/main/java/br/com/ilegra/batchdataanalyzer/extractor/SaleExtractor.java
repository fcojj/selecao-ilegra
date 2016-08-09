package br.com.ilegra.batchdataanalyzer.extractor;

import br.com.ilegra.batchdataanalyzer.bean.Bean;
import br.com.ilegra.batchdataanalyzer.bean.Sale;
import br.com.ilegra.batchdataanalyzer.bean.SaleItem;
import br.com.ilegra.batchdataanalyzer.bean.Salesman;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class SaleExtractor implements Extractor{

    private final static int TYPE_ID_INDEX = 0;
    private final static int ID_INDEX = 1;
    private final static int ITEMS_INDEX = 2;
    private final static int NAME_SALESMAN_INDEX = 3;
    private final SaleItemExtractor saleItemExtractor;

    public SaleExtractor() {
        this.saleItemExtractor = new SaleItemExtractor();
    }

    @Override
    public Bean extract(List<String> saleData) {
        List<SaleItem> saleItemList = new ArrayList<>();
        List<String> saleItemListDate = Arrays.asList(trimSaleItemsData(saleData).split(","));

        saleItemListDate.forEach(saleItemData->{
            saleItemList.add((SaleItem)saleItemExtractor.extract(Arrays.asList(saleItemData.split("-"))));
        });

        Bean sale  = new Sale(
                saleData.get(TYPE_ID_INDEX),
                saleData.get(ID_INDEX),
                saleItemList,
                new Salesman(saleData.get(NAME_SALESMAN_INDEX)));

        return sale;
    }

    private String trimSaleItemsData(List<String> saleData) {
        return saleData.get(ITEMS_INDEX).replace("[","").replace("]","");
    }
}
