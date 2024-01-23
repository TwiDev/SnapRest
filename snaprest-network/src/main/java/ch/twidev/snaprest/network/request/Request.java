package ch.twidev.snaprest.network.request;

import ch.twidev.snaprest.common.Callback;
import ch.twidev.snaprest.http.connection.ConnectionFactory;
import ch.twidev.snaprest.http.response.ResponseBody;
import ch.twidev.snaprest.network.bind.RequestType;
import ch.twidev.snaprest.network.headers.Header;
import ch.twidev.snaprest.network.util.URL;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Request {

    private final URL url;
    private final RequestType requestType;
    private final Header header;

    private RequestCallback callback;

    public Request(URL url, RequestType requestType, Header header, RequestCallback callback) {
        this.url = url;
        this.requestType = requestType;
        this.header = header;
        this.callback = callback;
    }

    public Request(URL url, RequestType requestType, Header header) {
        this.url = url;
        this.requestType = requestType;
        this.header = header;
    }

    public Request sendAsync() {
        return send(true);
    }

    public Request send() {
        return send(false);
    }

    public Request send(boolean async) {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();

        Callback<HttpURLConnection> conModifier = httpURLConnection -> {
            header.getHeaderProperties().forEach((key, value) -> httpURLConnection.setRequestProperty(key, value.toString()));
        };

        if(async) {
            connectionFactory.createAsyncConnection(url.getNetUrl(), requestType.toString(), conModifier, responseBody -> {
                if(responseBody == null) {
                    this.failRequest(RequestFailureReason.CANNOT_CREATE_CONNECTION_TO_URL, new NullPointerException());
                    return;
                }

                this.succeedRequest(responseBody);
            });

            return this;
        }

        try {
            ResponseBody responseBody = connectionFactory.createConnection(url.getNetUrl(), requestType.toString(), conModifier);

            this.succeedRequest(responseBody);
        } catch (IOException e) {
            this.failRequest(RequestFailureReason.CANNOT_CREATE_CONNECTION_TO_URL, e);
        }

        return this;
    }

    private void failRequest(RequestFailureReason requestFailureReason, Throwable throwable) {
        if(callback != null)
            callback.onFailure(RequestFailureReason.CANNOT_CREATE_CONNECTION_TO_URL, throwable);
    }

    private void succeedRequest(ResponseBody responseBody) {
        if(callback != null)
            callback.onSucceed(responseBody);
    }

    public RequestCallback getCallback() {
        return callback;
    }

    public void setCallback(RequestCallback callback) {
        this.callback = callback;
    }

    public URL getUrl() {
        return url;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public Header getHeader() {
        return header;
    }
}
