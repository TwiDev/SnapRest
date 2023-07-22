package ch.twidev.snaprest.api.util;

import ch.twidev.snaprest.api.lang.Nullable;

public abstract class Assert {

    public static void notNull(@Nullable Object object, String message) {
        if(object == null) throw new IllegalArgumentException(message);
    }

}
