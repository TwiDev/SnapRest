package ch.twidev.snaprest.common;

import ch.twidev.snaprest.common.lang.Nullable;

public interface FutureCallback<T> {

    void run(@Nullable T t);

}
