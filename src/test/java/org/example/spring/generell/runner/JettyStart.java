package org.example.spring.generell.runner;

import org.eclipse.jetty.server.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

        Server server = ServerFactory.createServer(args);

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
        server = ServerFactory.createServerWithRandomPort();
        server.start();
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


}
