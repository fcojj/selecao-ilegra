package br.com.ilegra.batchdataanalyzer.extractor;

import br.com.ilegra.batchdataanalyzer.bean.Customer;
import br.com.ilegra.batchdataanalyzer.bean.Bean;

import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class CustomerExtractor implements Extractor{

    private final static int TYPE_ID_INDEX = 0;
    private final static int CNPJ_INDEX = 1;
    private final static int NAME_INDEX = 2;
    private final static int BUSSINESS_AREA_INDEX = 3;

    @Override
    public Bean extract(List<String> customerData) {
        Bean customer  = new Customer(
                customerData.get(TYPE_ID_INDEX),
                customerData.get(CNPJ_INDEX),
                customerData.get(NAME_INDEX),
                customerData.get(BUSSINESS_AREA_INDEX));

        return customer;
    }
}
