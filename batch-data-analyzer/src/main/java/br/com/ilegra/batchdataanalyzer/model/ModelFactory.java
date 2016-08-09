package br.com.ilegra.batchdataanalyzer.model;

import br.com.ilegra.batchdataanalyzer.bean.Customer;
import br.com.ilegra.batchdataanalyzer.bean.Sale;
import br.com.ilegra.batchdataanalyzer.bean.Salesman;
import br.com.ilegra.batchdataanalyzer.extractor.CustomerExtractor;
import br.com.ilegra.batchdataanalyzer.extractor.SaleExtractor;
import br.com.ilegra.batchdataanalyzer.extractor.SalesmanExtractor;

import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class ModelFactory {
    public static final int TYPE_ID_INDEX = 0;
    public static final String SALESMAN_TYPE_ID = "001";
    public static final String CUSTOMER_TYPE_ID = "002";
    public static final String SALE_TYPE_ID = "003";
    private CustomerExtractor customerExtractor;
    private SaleExtractor saleExtractor;
    private SalesmanExtractor salesmanExtractor;
    private CustomerModel customerModel;
    private SaleModel saleModel;
    private SalesmanModel salesmanModel;


    public ModelFactory() {
        this.customerExtractor = new CustomerExtractor();
        this.saleExtractor = new SaleExtractor();
        this.salesmanExtractor = new SalesmanExtractor();
        this.customerModel = new CustomerModel();
        this.saleModel = new SaleModel();
        this.salesmanModel = new SalesmanModel();
    }

    public void manufactureModel(List<String> dataModel){
        String typeId = dataModel.get(TYPE_ID_INDEX);
        if(typeId.equals(SALESMAN_TYPE_ID)){
            salesmanModel.add((Salesman)salesmanExtractor.extract(dataModel));
        }else if(typeId.equals(CUSTOMER_TYPE_ID)){
            customerModel.add((Customer)customerExtractor.extract(dataModel));
        }else if(typeId.equals(SALE_TYPE_ID)){
            saleModel.add((Sale)saleExtractor.extract(dataModel));
        }
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public SaleModel getSaleModel() {
        return saleModel;
    }

    public SalesmanModel getSalesmanModel() {
        return salesmanModel;
    }
}
