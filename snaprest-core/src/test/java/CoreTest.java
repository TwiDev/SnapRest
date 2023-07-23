import ch.twidev.snaprest.core.SnapRestCore;
import ch.twidev.snaprest.http.response.ResponseBody;
import ch.twidev.snaprest.network.bind.RequestType;
import ch.twidev.snaprest.network.request.Request;
import ch.twidev.snaprest.network.request.RequestCallback;
import ch.twidev.snaprest.network.request.RequestFailureReason;
import ch.twidev.snaprest.network.util.URL;
import org.junit.Test;

public class CoreTest {

    private static final URL url = URL.fromString("https://yesno.wtf/api");

    @Test
    public void initRequest() {
        SnapRestCore.init();

        Request request = SnapRestCore.getInstance().getRequestFactory().createRequest(url, RequestType.GET, new RequestCallback() {
            @Override
            public void onSucceed(ResponseBody responseBody) {
                System.out.println(responseBody.parseString());
            }

            @Override
            public void onFailure(RequestFailureReason requestFailureType1) {

            }
        }).send();

    }

}
