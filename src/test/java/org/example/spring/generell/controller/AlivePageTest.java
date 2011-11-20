package org.example.spring.generell.controller;

import org.eclipse.jetty.server.Server;
import org.example.spring.generell.runner.ServerFactory;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static junit.framework.Assert.assertTrue;


/**
 *
 */

public class AlivePageTest {

    private static Server server;
    private WebDriver driver;

    @BeforeClass
    public static void startJetty() throws Exception {
        server = ServerFactory.createServer(8080);
        server.start();
    }

    @Before
    public void startWebDriver(){
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080/example/alive");
    }

    @Test
    public void testAliveCheck() throws Exception {
        assertTrue(driver.getPageSource().contains("healthy"));
    }

    @After
    public void quitWebdriver(){
        driver.quit();
    }

    @AfterClass
    public static void stopJetty() throws Exception {
        server.stop();
    }
}
