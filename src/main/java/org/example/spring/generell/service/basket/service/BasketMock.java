package org.example.spring.generell.service.basket.service;

import org.example.spring.generell.service.basket.api.Basket;
import org.example.spring.generell.service.basket.apimodel.BasketItem;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@Component
public class BasketMock implements Basket{
    @Override
    public List<BasketItem> getItems() {
        return Arrays.asList(new BasketItem("Product A", 25.95), new BasketItem("Product B", 12.49),
                new BasketItem("Product C", 5.95));
    }
}
