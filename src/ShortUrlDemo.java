import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xiefei on 17/7/5.
 */
public class ShortUrlDemo {


    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void LongToShort() throws Exception {
        String url="http://ws.urlservice.fx.fws.qa.nt.ctripcorp.com/urlService-api/api/Shortenter/PostDisFormalTm";
        String longUrl="http://blog.csdn.net/stronglyh/article/details/49488465";
        String headParm="{\"AppID\":\"100001001\",\"Type\":1}";
        String longUrlJson= objectMapper.writeValueAsString(longUrl);
        String result=sendPost(url,headParm,longUrlJson);
        System.out.println(result);
    }



    public static String sendPost(String url, String headParm ,String bodyParam) throws IOException{
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) conn;
            conn.setDoOutput(true);
            conn.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bodyParam.length()));
            //Header参数
            httpURLConnection.setRequestProperty("ctrip_shorturl", headParm);

            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(bodyParam);
            outputStreamWriter.flush();

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        }
        finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return resultBuffer.toString();
    }
}
