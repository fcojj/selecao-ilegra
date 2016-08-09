package br.com.ilegra.batchdataanalyzer.model;

import br.com.ilegra.batchdataanalyzer.bean.Customer;
import br.com.ilegra.batchdataanalyzer.bean.Salesman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class CustomerModel {
    private List<Customer> customerList;

    public CustomerModel() {
        this.customerList = new ArrayList<>();
    }

    public void add(Customer newCustomer){
        boolean isExist = customerList.stream()
                .anyMatch(oldCustomer -> isNameEquals(newCustomer, oldCustomer));

        if(!isExist) {
            customerList.add(newCustomer);
        }
    }

    private boolean isNameEquals(Customer newCustomer, Customer oldCustomer) {
        return oldCustomer.getName().toUpperCase().equals(newCustomer.getName().toUpperCase());
    }

    public List<Customer> getAll(){
        return customerList;
    }
}
