package com.example.lenovo.inequalitysign.http;

import com.example.lenovo.inequalitysign.entity.Dining;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
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

/**
 * Created by ff on 2016/12/8.
 */
public class Httpss {
    private String string = "";
    List<Dining> ls = new ArrayList<>();

    public String setAndGet(String u, NameValuePair...pairs) {
        try {
            URI url = new URI(u);
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            List<NameValuePair> pairss = new ArrayList<>();
            for(NameValuePair pair:pairs){
                pairss.add(new BasicNameValuePair(pair.getName()+"",pair.getValue()+""));
            }
            HttpEntity entity = new UrlEncodedFormEntity(pairss, "utf-8");
            httppost.setEntity(entity);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
                String string1 ="";

                while ((string1 = buffer.readLine()) != null) {
                    string += string1;
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
    public List<Dining> parser(String s){

        try {
            JSONArray array = new JSONArray(string);
            for(int i =0 ; i < array.length();i++){
                JSONObject object = array.getJSONObject(i);
                String urll = object.getString("shop_img_small");
                String name = object.getString("shop_name");
                String intro = object.getString("shop_description");
                ls.add(new Dining(urll,name,intro));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ls;
    }

}
