package org.example.spring.jasperreport.service.basket.apimodel;

import java.util.UUID;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
public class BasketItem {

    private UUID id;
    private String name;
    private Double total;

    public BasketItem (String name, Double total){
        this.name = name;
        this.total = total;
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Double getTotal() {
        return total;
    }
}
