package br.com.ilegra.batchdataanalyzer.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class Salesman implements Serializable, Bean {
    public static final String TYPE_ID = "001";
    public static final String EMPTY_STRING = "";
    public static final String SALARY_ZERO = "0.0";
    private String typeId;
    private String cpf;
    private String name;
    private BigDecimal salary;

    public Salesman(String typeId, String cpf, String name, BigDecimal salary) {
        this.typeId = typeId;
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public Salesman(String name) {
        this.typeId = TYPE_ID;
        this.cpf = EMPTY_STRING;
        this.name = name;
        this.salary = new BigDecimal(SALARY_ZERO);
    }

    public String getTypeId() {
        return typeId;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }


    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "typeId='" + typeId + '\'' +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}'+"\r\n";
    }
}
