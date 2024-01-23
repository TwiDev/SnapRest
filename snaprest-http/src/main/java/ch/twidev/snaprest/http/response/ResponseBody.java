package ch.twidev.snaprest.http.response;

import ch.twidev.snaprest.common.lang.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ResponseBody {

    private final InputStream inputStream;
    private final String responseMessage;
    private final String rawOutput;
    private final int responseCode;
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    public ResponseBody(InputStream inputStream, String responseMessage, int responseCode) {
        this.inputStream = inputStream;
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;

        int chunk = 0;
        byte[] data = new byte[256];

        while(true)
        {
            try {
                if (-1 == (chunk = inputStream.read(data))) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            byteArrayOutputStream.write(data, 0, chunk);
        }

        try {
            inputStream.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), StandardCharsets.UTF_8));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = in.readLine()) != null)
                responseStrBuilder.append(inputStr);

            in.close();

            this.rawOutput = responseStrBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
        return rawOutput;
    }

    public @Nullable JSONObject parseJson() {
        try {
            return new JSONObject(rawOutput);
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "responseMessage='" + responseMessage + '\'' +
                ", responseCode=" + responseCode + '\'' +
                ", rawOutput='" + rawOutput +
                '}';
    }
}
