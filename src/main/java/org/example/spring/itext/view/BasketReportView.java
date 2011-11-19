package org.example.spring.itext.view;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.pdf.PdfWriter;
import org.example.spring.jasperreport.service.basket.api.Basket;
import org.example.spring.jasperreport.service.basket.apimodel.BasketItem;
import org.example.spring.jasperreport.service.cms.api.CmsRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("itextBasketReport")
public class BasketReportView extends AbstractPdfView {

    @Autowired
    Basket basket;

    @Autowired
    CmsRessource cmsRessource;

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        document.add(new Paragraph(cmsRessource.getHeader()));

        Table basketItemTable = new Table(3);
        basketItemTable.addCell("UUID");
        basketItemTable.addCell("Name");
        basketItemTable.addCell("Total");

        for(BasketItem item : basket.getItems()){
            basketItemTable.addCell(item.getId().toString());
            basketItemTable.addCell(item.getName());
            basketItemTable.addCell(item.getTotal().toString());
        }

        document.add(basketItemTable);

        String footer = cmsRessource.getFooter();
        List<Element> arrayList = HTMLWorker.parseToList(new StringReader(footer), new StyleSheet());
        for(Element element : arrayList){
            document.add(element);
        }
    }
}
