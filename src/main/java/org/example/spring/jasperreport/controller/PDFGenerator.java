package org.example.spring.jasperreport.controller;

import org.example.spring.jasperreport.service.basket.api.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@Controller
public class PDFGenerator {

    @Autowired
    Basket basket;

    @RequestMapping(value = "/example.pdf", method = RequestMethod.GET)
    public ModelAndView generatePdf(ModelMap modelMap){
        modelMap.put("basketItems", basket.getItems());
        modelMap.put("format", "pdf");
        return new ModelAndView("example", modelMap);
    }
}
