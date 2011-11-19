package org.example.spring.itext.controller;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.spring.jasperreport.service.basket.api.Basket;
import org.example.spring.jasperreport.service.cms.api.CmsRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@Controller("iTextPdfGenerator")
public class PDFGenerator {

    @Autowired
    Basket basket;

    @Autowired
    CmsRessource cmsRessource;

    @RequestMapping(value = "/itext-example.pdf", method = RequestMethod.GET)
    public ModelAndView generateBasketPdf(){
        return new ModelAndView("itextBasketReport");
    }


}
