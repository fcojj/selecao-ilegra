package br.com.ilegra.batchdataanalyzer.model;

import br.com.ilegra.batchdataanalyzer.bean.Salesman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class SalesmanModel {

    private List<Salesman> salesmanList;

    public SalesmanModel() {
        this.salesmanList = new ArrayList<>();
    }

    public void add(Salesman newSalesman){
        boolean isExist = isExistSalesman(newSalesman);
        if(!isExist){
            salesmanList.add(newSalesman);
        }
    }

    private boolean isExistSalesman(Salesman newSalesman) {
        return salesmanList.stream()
                .anyMatch(oldSalesman ->{
                    if(isNameEquals(newSalesman, oldSalesman) && oldSalesman.getCpf().isEmpty()){
                        if(!newSalesman.getCpf().isEmpty()) {
                            updateSalesman(newSalesman, oldSalesman);
                        }

                        return true;
                    }else{

                        return false;
                    }
                });
    }

    private void updateSalesman(Salesman newSalesman, Salesman oldSalesman) {
        oldSalesman.setCpf(newSalesman.getCpf());
        oldSalesman.setSalary(newSalesman.getSalary());
        oldSalesman.setTypeId(newSalesman.getTypeId());
    }

    public List<Salesman> getAll(){
        return salesmanList;
    }

    private boolean isNameEquals(Salesman newSalesman, Salesman salesman) {
        return salesman.getName().toUpperCase().equals(newSalesman.getName().toUpperCase());
    }


}
