package ch.twidev.snaprest.network.request;

import ch.twidev.snaprest.network.headers.Header;
import ch.twidev.snaprest.network.response.ResponseBody;

public class RequestResponse {

    private final RequestCallback requestCallback;
    private int httpCode;
    private Header responseHeader;
    private ResponseBody responseBody;

    public RequestResponse(RequestCallback requestCallback, int httpCode, Header responseHeader, ResponseBody responseBody) {
        this.requestCallback = requestCallback;
        this.httpCode = httpCode;
        this.responseHeader = responseHeader;
        this.responseBody = responseBody;
    }
}
