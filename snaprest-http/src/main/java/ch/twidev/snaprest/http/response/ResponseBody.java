package ch.twidev.snaprest.http.response;

import ch.twidev.snaprest.common.lang.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ResponseBody {

    private final InputStream inputStream;
    private final String responseMessage;
    private final int responseCode;

    public ResponseBody(InputStream inputStream, String responseMessage, int responseCode) {
        this.inputStream = inputStream;
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public @Nullable String parseString() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(this.inputStream));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            return content.toString();
        } catch (IOException exception) {
            exception.printStackTrace();

            return null;
        }
    }

    public @Nullable JSONObject parseJson() {
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(this.inputStream, StandardCharsets.UTF_8));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            return new JSONObject(responseStrBuilder.toString());
        } catch (IOException | JSONException e) {
            e.printStackTrace();

            return null;
        }
    }
}
