package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.inequalitysign.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DiningInformationActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn;
    private Bitmap bitmap;
    private String name;
    private String url;
    private TextView tv_name;
    private ImageView img;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_name.setText(name);

            img.setImageBitmap(bitmap);
        }
    };
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back3:
                    Intent i=new Intent(DiningInformationActivity.this,DiningActivity.class);
                    startActivity(i);
                    break;
                case R.id.btn_qh:
                    Intent intent = new Intent(DiningInformationActivity.this,OrderInformationActivity.class);
                    Intent ii = getIntent();
                    String name1 = ii.getStringExtra("Name");
                    String url1 = ii.getStringExtra("Url");
                    intent.putExtra("Name",name1);
                    intent.putExtra("Url",url1);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_information);
        finView();
        setOnClick();
        Intent i = getIntent();
        name = i.getStringExtra("Name");
        url = i.getStringExtra("Url");
        setContent();



    }

    private void setContent() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                http();
                Message msg = new Message();
                mHandler.sendMessage(msg);
            }
        }).start();

    }
    private void http() {
        try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)u.openConnection();
            InputStream in = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);

    }

    private void finView() {
        btn1=(Button)findViewById(R.id.back3);//退出按钮
        btn=(Button)findViewById(R.id.btn_qh);//取号按钮
        tv_name = (TextView)findViewById(R.id.name);
        img = (ImageView)findViewById(R.id.iv_logo);
    }
}
