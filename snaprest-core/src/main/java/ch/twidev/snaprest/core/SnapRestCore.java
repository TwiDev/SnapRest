package ch.twidev.snaprest.core;

import ch.twidev.snaprest.http.connection.ConnectionFactory;
import ch.twidev.snaprest.network.request.RequestFactory;

import java.util.logging.Logger;

public class SnapRestCore implements SnapRest{

    private static SnapRestCore instance;

    private static final String LOGGER_NAME = "SnapRest";
    public static final Logger LOGGER = Logger.getLogger(LOGGER_NAME);

    private final ConnectionFactory connectionFactory;
    private final RequestFactory requestFactory;

    public SnapRestCore() {
        super();

        instance = this;

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
        if(instance == null) {
            instance = new SnapRestCore();
        }

        return instance;
    }
}
