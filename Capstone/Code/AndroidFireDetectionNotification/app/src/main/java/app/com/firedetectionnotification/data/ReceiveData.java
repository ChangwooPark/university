package app.com.firedetectionnotification.data;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015-06-16.
 */
public class ReceiveData extends AsyncTask<Void,Void,Void> {

    public static String sensorData;

    @Override
    protected Void doInBackground(Void... params) {
        String url = "http://203.230.100.254:8080/Android/Temperature.do";
        //String url = "http://203.230.100.253:8080";
        HttpClient http = new DefaultHttpClient();

        try {

            ArrayList<NameValuePair> nameValuePairs =
                    new ArrayList<NameValuePair>();
            HttpParams param = http.getParams();
            HttpConnectionParams.setConnectionTimeout(param, 5000);
            HttpConnectionParams.setSoTimeout(param, 5000);

            HttpPost httpPost = new HttpPost(url);
            UrlEncodedFormEntity entityRequest =
                    null;
            try {
                entityRequest = new UrlEncodedFormEntity(nameValuePairs, "EUC-KR");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            httpPost.setEntity(entityRequest);

            HttpResponse response = http.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            BufferedReader buffreader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String line;
            String result = "";
            while ((line = buffreader.readLine()) != null) {
                result += line;
            }
            if (result != null) {
                JSONObject json = new JSONObject(result);

//                String test = json.getJSONObject("temperaturelist").toString();
                sensorData = json.getString("temperaturelist");
//                    JSONArray jarray = json.getJSONArray("temperaturelist");

//                    json = jarray.getJSONObject(0);

                Log.d("hong", "json : " + json);
                Log.d("hong", "result : " + result);
                Log.d("hong", "test : " + sensorData);
//                String name = json.getString("name");

            }

        } catch (Exception e) {
            Log.d("hong","error2");
            e.printStackTrace();

        }
        return null;
    }

    /*
    protected Void doInBackground(Void... params) {
        String url = "http://203.230.100.253:8080/Android/Temperature.do";
        //String url = "http://203.230.100.253:8080";

        Log.d("hong","receivedata접속");
        try{
            DefaultHttpClient client = HttpClient_Singleton.getInstance();

            HttpPost post = new HttpPost(url);

            HttpResponse response = client.execute(post);

            BufferedReader buffreader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String line;
            String result = "";
            while ((line = buffreader.readLine()) != null) {
                result += line;
            }

            if(result != null){
//                JSONObject json = new JSONObject(result);
//                JSONArray jArr = json.getJSONArray("temperature");
//
//
//                String[][]

                JSONObject json = new JSONObject(result);
                String test = json.getString("temperature");

                Log.d("hong","성공 테스트?" + test);

            }


//            HttpResponse response = client
        }catch (Exception e){
            Log.d("hong","receive error!!");
        }


        return null;
    }
    */
}
