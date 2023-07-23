package ch.twidev.snaprest.core;

import ch.twidev.snaprest.http.connection.ConnectionFactory;
import ch.twidev.snaprest.network.request.RequestFactory;

import java.util.logging.Logger;

public class SnapRestCore {

    private static SnapRestCore instance;

    private static final String LOGGER_NAME = "SnapRest";
    public static final Logger LOGGER = Logger.getLogger(LOGGER_NAME);

    private final ConnectionFactory connectionFactory;
    private final RequestFactory requestFactory;

    public SnapRestCore() {
        super();

        this.connectionFactory = new ConnectionFactory();
        this.requestFactory = new RequestFactory();
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public RequestFactory getRequestFactory() {
        return requestFactory;
    }

    public static SnapRestCore getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        instance = new SnapRestCore();
    }
}
