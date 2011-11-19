package org.example.spring.jasperreport;

import org.example.spring.jasperreport.service.basket.api.Basket;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@ContextConfiguration(locations = "classpath:/org/example/spring/jasperreport/spring-context.xml")
public class ContextTest extends AbstractJUnit4SpringContextTests{

    @Test
    public void testContext(){
        assertNotNull(applicationContext);

        Basket basket = applicationContext.getBean(Basket.class);
        assertNotNull(basket);
        assertEquals(basket.getItems().size(), 3);
    }

}
