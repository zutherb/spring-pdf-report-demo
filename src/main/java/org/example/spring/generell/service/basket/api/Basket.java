package org.example.spring.generell.service.basket.api;

import org.example.spring.generell.service.basket.apimodel.BasketItem;

import java.util.List;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
public interface Basket {
    List<BasketItem> getItems();
}
