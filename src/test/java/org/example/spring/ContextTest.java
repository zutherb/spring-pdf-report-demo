package org.example.spring;

import org.example.spring.generell.service.basket.api.Basket;
import org.example.spring.generell.service.cms.api.CmsRessource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@ContextConfiguration(locations = "classpath:/org/example/spring/spring-context.xml")
public class ContextTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    Basket basket;

    @Autowired
    CmsRessource cmsRessource;

    @Test
    public void testContext(){
        assertNotNull(applicationContext);

        assertNotNull(basket);
        assertEquals(basket.getItems().size(), 3);

        assertNotNull(cmsRessource);
    }

}
