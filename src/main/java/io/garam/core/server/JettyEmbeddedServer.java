package io.garam.core.server;

import io.garam.core.handlers.RootHandler;
import org.eclipse.jetty.server.Server;

/**
 * Root handler is located inside the server for convenience, but it will be extracted from server.
 *
 * @author hyeyoom
 */
public class JettyEmbeddedServer implements EmbeddedServer {

    private Server server;

    @Override
    public void init(EmbeddedServerConfiguration configuration) {
        server = new Server(configuration.getPort());
        server.setHandler(
                new RootHandler(
                        configuration.getHandlerMapping(),
                        configuration.getMiddlewares(),
                        configuration.getTemplateEngine()
                )
        );
    }

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

}
