package org.example.spring.jasperreport.runner;

import org.eclipse.jetty.ajp.Ajp13SocketConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
public class JettyStart {

    private Server server;

    public static void main(final String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("JettyStart <httpport> [ajpport] [sslport]");
            return;
        }
        System.setProperty("catalina.base", ".");

        Server server = createServer(args);

        try {
            jettyStartConsoleOutput(args[0]);
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(100);
        }
    }

    private static void jettyStartConsoleOutput(String port) {
        String message = ">>> STARTING SAMPLE PORTAL ON PORT %s , PRESS ANY KEY TO STOP";
        System.out.println(String.format(message, port));
    }

    @Before
    public void startJetty() throws Exception {
        Integer port = generateRandomPort();
        server = createServer(new String[]{port.toString()});
        jettyStartConsoleOutput(port.toString());
        server.start();
    }

    private Integer generateRandomPort() {
        Random rn = new Random();
        int n = 2*Short.MAX_VALUE - 9999;
        int i = rn.nextInt() % n;
        return 9999 + i;
    }

    @Test
    public void testJettyStart() throws Exception {
        assertFalse(server.isFailed());
        assertTrue(server.isRunning());
    }

    @After
    public void stopJetty() throws Exception{
        server.stop();
    }

    private static Server createServer(String[] args) {
        Server server = new Server(Integer.parseInt(args[0]));
        WebAppContext context = new WebAppContext();
        context.setContextPath("/example");
        context.setResourceBase("src/main/java/");
        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        context.setParentLoaderPriority(true);
        server.setHandler(context);

        Ajp13SocketConnector ajpConnector = new Ajp13SocketConnector();
        int ajpport = 8009;
        if( args.length == 2){
            ajpport = Integer.parseInt(args[1]);
        }
        ajpConnector.setPort(ajpport);
        server.addConnector(ajpConnector);
        return server;
    }
}
