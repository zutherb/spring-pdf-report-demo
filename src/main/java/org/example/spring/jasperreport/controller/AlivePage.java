package org.example.spring.jasperreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
@Controller
public class AlivePage {

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    @ResponseBody
    public String aliveCheck(){
        return "healthy";
    }
}
