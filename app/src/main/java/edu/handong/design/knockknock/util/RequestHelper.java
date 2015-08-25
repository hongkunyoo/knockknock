package edu.handong.design.knockknock.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by hongkunyoo on 15. 8. 22..
 */
public class RequestHelper {


    public static void request(String url, final Callback callback) {
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            String str = EntityUtils.toString(response.getEntity());
            callback.onCompleted(str);
        } catch (IOException e) {
            e.printStackTrace();
            callback.onCompleted("ERROR");
        }
    }

    public static interface Callback {
        public void onCompleted(String entity);
    }
}
