package io.garam.web.server;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Root handler is located inside the server for convenience, but it will be extracted from server.
 * TODO: extract handler from server with abstraction.
 *
 * @author hyeyoom
 */
public class JettyEmbeddedServer extends AbstractHandler implements EmbeddedServer {

    private Server server;

    @Override
    public void startServer() throws Exception {
        server.start();
        server.join();
    }

    @Override
    public void abort() throws Exception {
        server.stop();
        server.destroy();
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        baseRequest.setHandled(true);
    }
}
