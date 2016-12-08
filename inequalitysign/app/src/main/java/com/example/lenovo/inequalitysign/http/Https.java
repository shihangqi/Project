package com.example.lenovo.inequalitysign.http;

import android.util.Log;

import com.example.lenovo.inequalitysign.entity.Dining;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Https {
    private static String u = "http://10.7.88.35:8090/shop/home";
    private String str = "3";
    private String string="";
    public List<Dining> ls = new ArrayList<>();

    public List<Dining> setAndGet(String u) {


        try {
            URI url = new URI(u);
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            NameValuePair pair = new BasicNameValuePair("city", str);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(pair);
            HttpEntity entity = new UrlEncodedFormEntity(pairs, "utf-8");
            httppost.setEntity(entity);
            Log.e("----------1","1");
            HttpResponse response = httpclient.execute(httppost);
            Log.e("----------2","2");
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
                String string1 ="";

                while ((string1 = buffer.readLine()) != null) {
                    string += string1;
                }
            }
Log.e("-----------3",string);
            JSONArray array = new JSONArray(string);
            Log.e("---------------------陈晨",array.toString());
            for(int i =0 ; i < array.length();i++){
                JSONObject object = array.getJSONObject(i);
                String urll = object.getString("shop_img_small");
                String name = object.getString("shop_name");
                String intro = object.getString("shop_description");
                ls.add(new Dining(urll,name,intro));
    }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ls;
    }
}
