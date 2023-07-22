package ch.twidev.snaprest.api.bind;

import ch.twidev.snaprest.api.lang.Nullable;
import ch.twidev.snaprest.api.util.Assert;

public enum RequestType {

    GET,
    HEAD,
    POST,
    PUT,
    PATCH,
    DELETE,
    OPTIONS,
    TRACE;

    @Nullable
    public static RequestType resolve(String method) {
        Assert.notNull(method, "Method name must be valid");

        try {
            return RequestType.valueOf(method);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
