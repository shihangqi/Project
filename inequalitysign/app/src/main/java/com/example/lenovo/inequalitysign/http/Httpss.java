package com.example.lenovo.inequalitysign.http;

import com.example.lenovo.inequalitysign.entity.Comment;
import com.example.lenovo.inequalitysign.entity.Dining;
import com.example.lenovo.inequalitysign.entity.Order;
import com.example.lenovo.inequalitysign.entity.Rank;

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
    List<Rank> ls_Rank = new ArrayList<>();
    List<Order> ls_Order = new ArrayList<>();
    List<Comment> ls_Comment = new ArrayList<>();

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
            JSONArray array = new JSONArray(s);
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
    public List<Rank> parserRank(String s){
        try {
            JSONArray array = new JSONArray(s);
            for(int i = 0;i < array.length(); i++){
                JSONObject object = array.getJSONObject(i);
                String url = object.getString("shop_img_small");
                String name = object.getString("shop_name");
                String address = object.getString("shop_address");
                int count = object.getInt("shop_count");
                ls_Rank.add(new Rank(url,name,address,count));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ls_Rank;
    }
//    public List<Order> parserOrder(String s){
//        try {
//            JSONArray array = new JSONArray(s);
//            for(int i = 0;i < array.length(); i++){
//                JSONObject object = array.getJSONObject(i);
//                String url = object.getString("shop_img_small");
//                String name = object.getString("shop_name");
//                String address = object.getString("shop_address");
//                int count = object.getInt("shop_count");
//                ls_Order.add(new Order(i,url,name,address,count));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return ls_Order;
//    }
    public List<Comment> parserComment(String s){
        try {
            JSONArray array1 = new JSONArray(s);
            for(int i = 0;i < array1.length(); i++) {
                JSONObject object = array1.getJSONObject(i);
                int star = object.getInt("star");
                String user_name = object.getString("user_name");
                String time = object.getString("time");
                String shop_name = object.getString("shop_name");
                String  content = object.getString("content");
                ls_Comment.add(new Comment(user_name,time,content,shop_name,star));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  ls_Comment;
    }

}
