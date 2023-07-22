package ch.twidev.snaprest.network.request;

import ch.twidev.snaprest.network.bind.RequestType;
import ch.twidev.snaprest.network.headers.Header;
import ch.twidev.snaprest.network.util.URL;

public class RequestFactory {

    Request createRequest(URL url) {
        return createRequest(url, RequestType.GET, Header.empty());
    }

    Request createRequest(URL url, RequestType requestType) {
        return createRequest(url, requestType, Header.empty());
    }

    Request createRequest(URL url, RequestType requestType, Header requestHeader) {
        return new Request(url, requestType, requestHeader);

    }

}
