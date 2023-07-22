package ch.twidev.snaprest.network.request;

public interface RequestCallback {

    public void onSucceed(RequestResponse requestResponse);

    public void onFailure(RequestFailureReason requestFailureType1);

}
