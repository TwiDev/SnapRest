package ch.twidev.snaprest.network.headers;

import ch.twidev.snaprest.common.lang.Nullable;
import ch.twidev.snaprest.common.util.Assert;

import java.util.HashMap;

public class Header {

    private final HashMap<String, Object> headerProperties = new HashMap<>();

    public void setProperty(String key, Object value) {
        this.headerProperties.put(key, value);
    }

    public @Nullable Object readProperty(String key) {
        Assert.needElement(headerProperties, key, "Header doesn't contains this key");

        return headerProperties.get(key);
    }

    public static Header empty() {
        return new Header();
    }

}
