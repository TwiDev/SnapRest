package ch.twidev.snaprest.network.request;

import ch.twidev.snaprest.network.bind.RequestType;
import ch.twidev.snaprest.network.headers.Header;
import ch.twidev.snaprest.network.util.URL;

public class RequestFactory {

    public Request createRequest(URL url) {
        return createRequest(url, RequestType.GET, Header.empty());
    }

    public Request createRequest(URL url, RequestType requestType) {
        return createRequest(url, requestType, Header.empty());
    }

    public Request createRequest(URL url, RequestType requestType, Header requestHeader) {
        return new Request(url, requestType, requestHeader);
    }

    public Request createRequest(URL url, RequestCallback callback) {
        return createRequest(url, RequestType.GET, Header.empty(), callback);
    }

    public Request createRequest(URL url, RequestType requestType, RequestCallback callback) {
        return createRequest(url, requestType, Header.empty(), callback);
    }

    public Request createRequest(URL url, RequestType requestType, Header requestHeader, RequestCallback callback) {
        return new Request(url, requestType, requestHeader, callback);
    }

}
