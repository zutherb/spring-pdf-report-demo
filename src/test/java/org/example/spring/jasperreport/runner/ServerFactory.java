package org.example.spring.jasperreport.runner;

import org.eclipse.jetty.ajp.Ajp13SocketConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.Random;

/**
 * @author Bernd Zuther <a href="mailto:bernd.zuther@me.com">bernd.zuther@me.com</a>
 */
public class ServerFactory {

    public static Server createServerWithRandomPort(){
       return createServer(new String[]{generateRandomPort().toString()});
    }

    public static Server createServer(Integer port) {
        return createServer(new String[]{port.toString()});
    }

    public static Server createServer(Integer port, Integer ajp) {
        return createServer(new String[]{port.toString(), ajp.toString()});
    }

    public static Server createServer(String ... args) {
        if (args.length < 1) {
            throw new IllegalArgumentException ("You must set at least one argument");
        }

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

    private static Integer generateRandomPort() {
        Random randomNumber = new Random();
        int n = 2*Short.MAX_VALUE - 9999;
        int i = randomNumber.nextInt() % n;
        return 9999 + i;
    }
}
