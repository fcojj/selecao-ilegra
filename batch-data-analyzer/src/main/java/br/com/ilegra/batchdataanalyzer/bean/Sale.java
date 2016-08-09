package br.com.ilegra.batchdataanalyzer.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fco Jonas Rodrigues on 09/08/2016.
 */
public class Sale implements Serializable, Bean {
    private String typeId;
    private String id;
    private List<SaleItem> saleItems;
    private Salesman salesman;

    public Sale(String typeId, String id, List<SaleItem> saleItems, Salesman salesman) {
        this.id = id;
        this.typeId = typeId;
        this.saleItems = saleItems;
        this.salesman = salesman;
    }

    public String getId() {
        return id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "typeId='" + typeId + '\'' +
                ", id='" + id + '\'' +
                ", saleItems=" + saleItems +
                ", salesman=" + salesman +
                '}'+"\r\n";
    }
}
