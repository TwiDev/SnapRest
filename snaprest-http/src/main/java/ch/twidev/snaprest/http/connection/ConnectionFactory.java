package ch.twidev.snaprest.http.connection;

import ch.twidev.snaprest.common.Callback;
import ch.twidev.snaprest.common.FutureCallback;
import ch.twidev.snaprest.http.response.ResponseBody;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionFactory {

    private static ConnectionFactory instance;

    private final ExecutorService connectionPool;

    public ConnectionFactory() {
        this.connectionPool = Executors.newCachedThreadPool();

        instance = this;
    }

    public ConnectionFactory(ExecutorService connectionPool) {
        this.connectionPool = connectionPool;

        instance = this;
    }

    public static ConnectionFactory getInstance() {
        return instance;
    }

    public ResponseBody createConnection(URL url, String requestMethod, Callback<HttpURLConnection> conModifier) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(requestMethod);
        conModifier.run(con);

        ResponseBody responseBody = new ResponseBody(
                con.getInputStream(),
                con.getResponseMessage(),
                con.getResponseCode()
        );

        con.disconnect();

        return responseBody;
    }

    public void createAsyncConnection(URL url, String requestMethod, Callback<HttpURLConnection> conModifier, FutureCallback<ResponseBody> futureCallback) {
        connectionPool.execute(() -> {
            try {
                futureCallback.run(
                        this.createConnection(url, requestMethod, conModifier)
                );
            } catch (IOException e) {
                futureCallback.run(null);
            }
        });
    }

}
