package org.example.spring.jasperreport.service.cms.impl;

import org.example.spring.jasperreport.service.cms.api.CmsRessource;
import org.springframework.stereotype.Service;

@Service
public class CmsRessourceMock implements CmsRessource {
    @Override
    public String getHeader() {
        return "<p>Ich bin ein <b>T<sub>23</sub>-Header</b> und in Html</p>";
    }

    @Override
    public String getFooter() {
        return "<p>Ich bin ein <b>T<sub>23</sub>-Footer</b> und in Html</p>";
    }
}
