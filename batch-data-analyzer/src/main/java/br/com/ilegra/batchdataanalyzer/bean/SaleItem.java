package br.com.ilegra.batchdataanalyzer.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Jonas Rodrigues on 09/08/2016.
 */
public class SaleItem implements Serializable, Bean {
    private String id;
    private Long amount;
    private BigDecimal price;

    public SaleItem(String id, Long amount, BigDecimal price) {
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public Long getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}'+"\r\n";
    }
}
