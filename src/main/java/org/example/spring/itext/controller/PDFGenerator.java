package org.example.spring.itext.controller;


import org.example.spring.generell.service.basket.api.Basket;
import org.example.spring.generell.service.cms.api.CmsRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@Controller("iTextPdfGenerator")
public class PDFGenerator {

    @Autowired
    Basket basket;

    @Autowired
    CmsRessource cmsRessource;

    @RequestMapping(value = "/itext-example1.pdf", method = RequestMethod.GET)
    public ModelAndView generateBasketPdf(){
        return new ModelAndView("itextBasketReport");
    }

    @RequestMapping(value = "/itext-example2.pdf", method = RequestMethod.GET)
    public ModelAndView generateBasketPdfWithTemplate(){
        return new ModelAndView("iTextBasketReportFromTemplate");
    }


}
