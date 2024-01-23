import ch.twidev.snaprest.core.SnapRest;
import ch.twidev.snaprest.core.SnapRestCore;
import ch.twidev.snaprest.core.SnapRestProvider;
import ch.twidev.snaprest.http.response.ResponseBody;
import ch.twidev.snaprest.network.bind.RequestType;
import ch.twidev.snaprest.network.request.Request;
import ch.twidev.snaprest.network.request.RequestCallback;
import ch.twidev.snaprest.network.request.RequestFailureReason;
import ch.twidev.snaprest.network.util.URL;
import org.junit.Test;

public class CoreTest {

    private SnapRest snapRest;

    private static final URL url = URL.fromString("https://yesno.wtf/api");

    @Test
    public void initRequest() {
        this.snapRest = new SnapRestProvider().getInstance();

        Request request = SnapRestCore.getInstance().getRequestFactory().createRequest(url, RequestType.GET, new RequestCallback() {
            @Override
            public void onSucceed(ResponseBody responseBody) {
                System.out.println("Succeed");
                System.out.println("Response: " + responseBody.parseJson());
                System.out.println("Code: " + responseBody.getResponseCode());
                System.out.println("Code: " + responseBody.toString());
            }

            @Override
            public void onFailure(RequestFailureReason requestFailureType, Throwable throwable) {
                System.out.println("Fail " + requestFailureType.toString());
            }
        }).send();

    }

}
