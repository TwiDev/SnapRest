package ch.twidev.snaprest.network.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class URL {

    public static URL fromString(String url) {
        return new URL(url);
    }

    private final String baseUrl;

    private final java.net.URL netUrl;

    public URL(String baseUrl) {
        this.baseUrl = baseUrl;

        try {
            this.netUrl = new URI(baseUrl).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public java.net.URL getNetUrl() {
        return netUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
