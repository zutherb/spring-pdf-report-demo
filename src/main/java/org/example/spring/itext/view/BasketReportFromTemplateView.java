package org.example.spring.itext.view;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import org.example.spring.generell.service.basket.api.Basket;
import org.example.spring.generell.service.cms.api.CmsRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("iTextBasketReportFromTemplate")
public class BasketReportFromTemplateView extends AbstractPdfView {

    @Autowired
    Basket basket;

    @Autowired
    CmsRessource cmsRessource;

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClassPathResource classPathResource = new ClassPathResource("org/example/spring/itext/template/itext-template.pdf");
        PdfReader pdfReader = new PdfReader(classPathResource.getInputStream());

        for(int page = 0; page < pdfReader.getNumberOfPages();page++){
            document.add(new Paragraph("Hallo"));
        }
    }
}
