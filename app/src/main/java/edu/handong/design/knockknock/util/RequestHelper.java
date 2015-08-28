package edu.handong.design.knockknock.util;

import android.net.Uri;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by hongkunyoo on 15. 8. 22..
 */
public class RequestHelper {


    public static void request(String url, final Callback callback) {
//        String encoded= null;
//        try {
//            encoded= URLEncoder.encode(url, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        new AsyncTask<String, Void, String>(){

            @Override
            protected String doInBackground(String... params) {
                return innerRequest(params[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callback.onCompleted(s);
            }
        }.execute(url);
    }

    private static String innerRequest(String url) {
        HttpClient client = new DefaultHttpClient();
        URI uri = URI.create(url);

        HttpGet get = new HttpGet(uri);
        Logger.log(uri);
        try {
            HttpResponse response = client.execute(get);
            return EntityUtils.toString(response.getEntity());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static interface Callback {
        public void onCompleted(String entity);
    }
}
