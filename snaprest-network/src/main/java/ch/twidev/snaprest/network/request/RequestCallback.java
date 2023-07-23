package ch.twidev.snaprest.network.request;

import ch.twidev.snaprest.common.lang.NotNull;
import ch.twidev.snaprest.http.response.ResponseBody;

public interface RequestCallback {

    public void onSucceed(@NotNull ResponseBody responseBody);

    public void onFailure(RequestFailureReason requestFailureType1);

}
