package ch.twidev.snaprest.common.util;

import ch.twidev.snaprest.common.lang.Nullable;

public abstract class Assert {

    public static void notNull(@Nullable Object object, String message) {
        if(object == null) throw new IllegalArgumentException(message);
    }

}
