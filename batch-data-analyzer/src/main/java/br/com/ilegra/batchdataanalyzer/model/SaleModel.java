package br.com.ilegra.batchdataanalyzer.model;

import br.com.ilegra.batchdataanalyzer.bean.Sale;
import br.com.ilegra.batchdataanalyzer.bean.SaleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class SaleModel {
    private List<Sale> saleList;

    public SaleModel() {
        this.saleList = new ArrayList<>();
    }

    public void add(Sale customer){
        saleList.add(customer);
    }

    public List<Sale> getAll(){
        return saleList;
    }

    public void addItemSale(SaleItem saleItem, String saleId){
        saleList.forEach(sale -> {
            if(sale.getId().equals(saleId)){
                sale.getSaleItems().add(saleItem);
            }
        });
    }


}
