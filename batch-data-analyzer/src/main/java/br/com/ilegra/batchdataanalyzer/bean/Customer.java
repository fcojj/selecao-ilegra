package br.com.ilegra.batchdataanalyzer.bean;

import java.io.Serializable;

/**
 * Created by Fco Jonas Rodrigues on 09/08/2016.
 */
public class Customer implements Serializable, Bean {
    private String typeId;
    private String cnpj;
    private String name;
    private String businessArea;

    public Customer(String typeId, String cnpj, String name, String businessArea) {
        this.typeId = typeId;
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (typeId != null ? !typeId.equals(customer.typeId) : customer.typeId != null) return false;
        if (cnpj != null ? !cnpj.equals(customer.cnpj) : customer.cnpj != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        return businessArea != null ? businessArea.equals(customer.businessArea) : customer.businessArea == null;

    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (cnpj != null ? cnpj.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (businessArea != null ? businessArea.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "typeId='" + typeId + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", name='" + name + '\'' +
                ", businessArea='" + businessArea + '\'' +
                '}'+"\r\n";
    }
}
