package ch.twidev.snaprest.common.util;

import ch.twidev.snaprest.common.lang.Nullable;

import java.util.HashMap;

public abstract class Assert {

    public static void notNull(@Nullable Object object, String message) {
        if(object == null) throw new IllegalArgumentException(message);
    }

    public static void needElement(HashMap<?,?> hashMap, Object o, String message) {
        if(!hashMap.containsKey(o)) throw new IllegalArgumentException(message);
    }

}
