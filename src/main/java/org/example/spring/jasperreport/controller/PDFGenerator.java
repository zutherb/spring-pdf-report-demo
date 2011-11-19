package org.example.spring.jasperreport.controller;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.spring.jasperreport.service.basket.api.Basket;
import org.example.spring.jasperreport.service.cms.api.CmsRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@Controller("pdfGenerator")
public class PDFGenerator {

    @Autowired
    Basket basket;

    @Autowired
    CmsRessource cmsRessource;

    @RequestMapping(value = "/jasper-example.pdf", method = RequestMethod.GET)
    public ModelAndView generateBasketPdf(){
        // Assign the datasource to an instance of JRDataSource
		// JRDataSource is the datasource that Jasper understands
		// This is basically a wrapper to Java's collection classes
        JRDataSource basketDS = new JRBeanCollectionDataSource(basket.getItems());

        // In order to use Spring's built-in Jasper support,
		// We are required to pass our datasource as a map parameter
		// modelMap is the Model of our application
		Map<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("basketReport", basketDS);
        modelMap.put("HEADER", cmsRessource.getHeader());
        modelMap.put("FOOTER", cmsRessource.getHeader());


        // pdfReport is the View of our application
		// This is declared inside the jasper-views.xml
		ModelAndView modelAndView = new ModelAndView("pdfReport", modelMap);

		// Return the View and the Model combined
		return modelAndView;
    }


}
