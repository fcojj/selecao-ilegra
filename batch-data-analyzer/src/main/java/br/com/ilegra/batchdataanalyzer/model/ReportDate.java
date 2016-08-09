package br.com.ilegra.batchdataanalyzer.model;

import br.com.ilegra.batchdataanalyzer.bean.Sale;
import br.com.ilegra.batchdataanalyzer.bean.SaleItem;
import br.com.ilegra.batchdataanalyzer.bean.Salesman;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class ReportDate {

    public Long amountCustomerTotal;
    public Long amountCustomerCurrentFileDat;
    public Long amountSalesmanTotal;
    public Long amountSalesmanCurrentFileDat;
    public String worstSalesman;
    public String bestSaleId;

    public ReportDate() {
        this.amountCustomerTotal = new Long(0);
        this.amountCustomerCurrentFileDat = new Long(0);
        this.amountSalesmanTotal = new Long(0);
        this.amountSalesmanCurrentFileDat = new Long(0);
        this.worstSalesman = "";
        this.bestSaleId = "";
    }

    public Long getAmountCustomerCurrentFileDat(ModelFactory modelFactory) {
        amountCustomerCurrentFileDat = Long.valueOf(modelFactory.getCustomerModel().getAll().size())-amountCustomerTotal;
        amountCustomerTotal = Long.valueOf(modelFactory.getCustomerModel().getAll().size());

        return amountCustomerCurrentFileDat;
    }

    public Long getAmountSalesmanCurrentFileDat(ModelFactory modelFactory) {

        amountSalesmanCurrentFileDat = Long.valueOf(modelFactory.getSalesmanModel().getAll().size())-amountSalesmanTotal;
        amountSalesmanTotal = Long.valueOf(modelFactory.getSalesmanModel().getAll().size());

        return amountSalesmanCurrentFileDat;
    }

    public String getWorstSalesman(ModelFactory modelFactory) {

        String worstSalesman="";
        BigDecimal amount = new BigDecimal("0.0");
        BigDecimal amountMin = new BigDecimal("0.0");
        boolean flagFirstSalesman = true;

        for(Salesman salesman : modelFactory.getSalesmanModel().getAll()){
            String salesmanName = salesman.getName();

            for (Sale sale : modelFactory.getSaleModel().getAll()){
                if(sale.getSalesman().getName().equals(salesmanName)){
                    for(SaleItem saleItem : sale.getSaleItems()){
                        amount = amount.add(saleItem.getPrice().multiply(BigDecimal.valueOf(saleItem.getAmount())));
                    }
                }
            }

            if(flagFirstSalesman){
                amountMin = amount;
                worstSalesman= salesman.getName();
                flagFirstSalesman=false;
            }else{
                if (amount.compareTo(amountMin) == -1){
                    amountMin = amount;
                    worstSalesman= salesman.getName();
                }
            }
            amount = new BigDecimal(0.0);
        }



        return worstSalesman;
    }

    public String getBestSaleId(ModelFactory modelFactory) {
        String maxSaleId="";
        BigDecimal amount = new BigDecimal("0.0");
        BigDecimal amountMax = new BigDecimal("0.0");

        for(Sale sale : modelFactory.getSaleModel().getAll()){
            for (SaleItem saleItem : sale.getSaleItems()){
                amount = amount.add((saleItem.getPrice().multiply(BigDecimal.valueOf(saleItem.getAmount()))));
            }

            if(amount.compareTo(amountMax) == 1){
                amountMax = amount;
                maxSaleId = sale.getId();
            }
            amount = new BigDecimal(0.0);
        }

        return maxSaleId;
    }
}
