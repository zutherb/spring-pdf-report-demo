package org.example.spring.jasperreport.controller;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.spring.jasperreport.service.basket.api.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@Controller
public class PDFGenerator {

    @Autowired
    Basket basket;

    @RequestMapping(value = "/jasper-example.pdf", method = RequestMethod.GET)
    public ModelAndView generateBasketPdf(){
        // Assign the datasource to an instance of JRDataSource
		// JRDataSource is the datasource that Jasper understands
		// This is basically a wrapper to Java's collection classes
        JRDataSource basketDS = new JRBeanCollectionDataSource(basket.getItems());

        // In order to use Spring's built-in Jasper support,
		// We are required to pass our datasource as a map parameter
		// parameterMap is the Model of our application
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("basketReport", basketDS);

		// pdfReport is the View of our application
		// This is declared inside the jasper-views.xml
		ModelAndView modelAndView = new ModelAndView("pdfReport", parameterMap);

		// Return the View and the Model combined
		return modelAndView;
    }


}
