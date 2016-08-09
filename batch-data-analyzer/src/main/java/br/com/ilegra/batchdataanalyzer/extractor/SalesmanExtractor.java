package br.com.ilegra.batchdataanalyzer.extractor;

import br.com.ilegra.batchdataanalyzer.bean.Bean;
import br.com.ilegra.batchdataanalyzer.bean.Salesman;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class SalesmanExtractor implements Extractor{

    private final static int TYPE_ID_INDEX = 0;
    private final static int CPF_INDEX = 1;
    private final static int NAME_INDEX = 2;
    private final static int SALARY = 3;

    @Override
    public Bean extract(List<String> salesmanData) {
        Bean salesman  = new Salesman(
                salesmanData.get(TYPE_ID_INDEX),
                salesmanData.get(CPF_INDEX),
                salesmanData.get(NAME_INDEX),
                new BigDecimal(salesmanData.get(SALARY).replace(",",".")));

        return salesman;
    }


    public Bean extract(String salesmanName) {
        Bean salesman  = new Salesman(salesmanName);

        return salesman;
    }
}
