package ch.twidev.snaprest.network.request;

import ch.twidev.snaprest.network.bind.RequestType;
import ch.twidev.snaprest.network.headers.Header;
import ch.twidev.snaprest.network.util.URL;

public class Request {

    private final URL url;
    private final RequestType requestType;
    private final Header header;

    public Request(URL url, RequestType requestType, Header header) {
        this.url = url;
        this.requestType = requestType;
        this.header = header;
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
