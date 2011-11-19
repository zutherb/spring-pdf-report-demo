package org.example.spring.jasperreport.service.basket.api;

import org.example.spring.jasperreport.service.basket.apimodel.BasketItem;

import java.util.List;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
public interface Basket {
    List<BasketItem> getItems();
}
