package com.example.lenovo.inequalitysign.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.http.Httpss;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class YytActivity extends AppCompatActivity {
    private Button btn1;
    private DisplayImageOptions options;
    private Button btn;

    private String name;
    private String id;
    private TextView tv_name;
    private ImageView img;
    private String s;
    private String result;
    private TextView tv1;
    private TextView tv11;
    private TextView tv2;
    private TextView tv21;
    private TextView tv3;
    private TextView tv31;
    private int state = 0;//代表类型选择状态  如果选择了  则=1 否则 =0
    private String nowtype1;//表示现在是多少号
    private String alltype1;//表示总共有多少号
    private String nowtype2;
    private String alltype2;
    private String nowtype3;
    private String alltype3;
    private String type_name1;//业务类型
    private String type_name2;
    private String type_name3;
    private int type;//存储业务类型
    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private ImageButton ib1;
    private ImageButton ib2;
    private ImageButton ib3;
    private static int what;

    private TextView add;
    private String add1;
    private String img1;
    private String u = Utils.SHOP_URL+"store";
    private View.OnClickListener Listener3 =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ib1:
                    ib1.setImageResource(R.drawable.xuanzhong);
                    ib2.setImageResource(R.drawable.daixuan);
                    ib3.setImageResource(R.drawable.daixuan);
                    type =  1;
                    state =1;
                    break;
                case R.id.ib2:
                    ib2.setImageResource(R.drawable.xuanzhong);
                    ib1.setImageResource(R.drawable.daixuan);
                    ib3.setImageResource(R.drawable.daixuan);
                    state=1;
                    type =  2;
                    break;
                case R.id.ib3:
                    ib1.setImageResource(R.drawable.daixuan);
                    ib2.setImageResource(R.drawable.daixuan);
                    ib3.setImageResource(R.drawable.xuanzhong);
                    state =1;
                    type =  3;
                    break;
            }
        }
    };
    private View.OnClickListener Listener2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ib1:
                    ib1.setImageResource(R.drawable.xuanzhong);
                    ib2.setImageResource(R.drawable.daixuan);
                    type =  1;
                    state=1;
                    break;
                case R.id.ib2:
                    ib2.setImageResource(R.drawable.xuanzhong);
                    ib1.setImageResource(R.drawable.daixuan);
                    type =  2;
                    state=1;
                    break;

            }
        }
    };
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (what){
                case 1:
                    ib1 = (ImageButton)findViewById(R.id.ib1);
                    ib1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ib1.setImageResource(R.drawable.xuanzhong);
                            type = 1;
                        }
                    });
                    int i1 = Integer.parseInt(alltype1);
                    int k1 = Integer.parseInt(nowtype1);
                    tv1.setText(type_name1);
                    tv11.setText(i1-k1+"");
                    ll1.setVisibility(View.VISIBLE);
                    ll2.setVisibility(View.GONE);
                    ll3.setVisibility(View.GONE);

                case 2:
                    ib1 = (ImageButton)findViewById(R.id.ib1);
                    ib2 = (ImageButton)findViewById(R.id.ib2);
                    ib1.setOnClickListener(Listener2);
                    ib2.setOnClickListener(Listener2);
                    int i11 = Integer.parseInt(alltype1);
                    int k11 = Integer.parseInt(nowtype1);
                    int i2 = Integer.parseInt(alltype2);
                    int k2 = Integer.parseInt(nowtype1);
                    ll1.setVisibility(View.VISIBLE);
                    ll2.setVisibility(View.VISIBLE);
                    ll3.setVisibility(View.GONE);
                    tv1.setText(type_name1);
                    tv11.setText(i11-k11+"");
                    tv2.setText(type_name2);
                    tv21.setText(i2-k2+"");
                    break;
                case 3:
                    ib1 = (ImageButton)findViewById(R.id.ib1);
                    ib2 = (ImageButton)findViewById(R.id.ib2);
                    ib3 = (ImageButton)findViewById(R.id.ib3);
                    ib1.setOnClickListener(Listener3);
                    ib2.setOnClickListener(Listener3);
                    ib3.setOnClickListener(Listener3);
                    int ii1 = Integer.parseInt(alltype1);
                    int kk1 = Integer.parseInt(nowtype1);
                    int ii2 = Integer.parseInt(alltype2);
                    int kk2 = Integer.parseInt(nowtype1);
                    int i3 = Integer.parseInt(alltype3);
                    int k3 = Integer.parseInt(nowtype1);
                    ll1.setVisibility(View.VISIBLE);
                    ll2.setVisibility(View.VISIBLE);
                    ll3.setVisibility(View.VISIBLE);
                    tv1.setText(type_name1);
                    tv11.setText(ii1-kk1+"");
                    tv2.setText(type_name2);
                    tv21.setText(ii2-kk2+"");
                    tv3.setText(type_name3);
                    tv31.setText(i3-k3+"");
                    break;
            }
            add.setText(add1);
            tv_name.setText(name);
            ImageLoader.getInstance().displayImage(img1,img);



        }
    };
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back3:
                    String start = getIntent().getStringExtra("Context");
                    if(start.equals("HomeFragment") ){
                        Utils.flag =1;
                        Intent intent1 = new Intent(YytActivity.this,MainActivity.class);
                        startActivity(intent1);
                    }else{
                        Intent i=new Intent(YytActivity.this,DiningActivity.class);
                        startActivity(i);
                    }
                    break;
                case R.id.btn_qh:
                    if(state == 0){
                        AlertDialog.Builder adb = new AlertDialog.Builder(YytActivity.this);
                        adb.setTitle("温馨提示");
                        adb.setTitle("请选择业务类型");
                        adb.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        adb.setPositiveButton("确定",null);
                        adb.create();
                        adb.show();
                    }else{
                        Intent ii = getIntent();
                        String name1 = ii.getStringExtra("Name");
                        String id = ii.getStringExtra("Id");
                        String start1 = ii.getStringExtra("Context");
                        Intent intent = new Intent(YytActivity.this,OrderInformationActivity.class);
                        intent.putExtra("Type",type+"");
                        intent.putExtra("Name",name1);
                        intent.putExtra("Id",id);
                        intent.putExtra("Context",start1);
                        startActivity(intent);
                    }

                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yyt_information);
        finView();
        setOnClick();
        init();

        Intent i = getIntent();
        name = i.getStringExtra("Name");
        id = i.getStringExtra("Id");
        setContent();
    }
    private void init() {
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_stub) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.ic_empty)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.ic_error)// 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)  // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)  // 设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)
                .displayer(new CircleBitmapDisplayer(Color.WHITE, 5))// 设置成圆角图片
                .build();// 创建配置过得DisplayImageOption对象
    }
    private void setContent() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                Httpss http = new Httpss();
                NameValuePair pair = new BasicNameValuePair("shop_id",id);
                s = http.setAndGet(u,pair);

                try {

                    JSONObject object = new JSONObject(s);
                    nowtype1 = object.getString("now_type1");
                    nowtype2 = object.getString("now_type2");
                    nowtype3 = object.getString("now_type3");
                    type_name1 = object.getString("name_type1");
                    type_name2 = object.getString("name_type2");
                    type_name3 = object.getString("name_type3");
                    alltype1 = object.getString("all_type1");
                    alltype2 = object.getString("all_type2");
                    alltype3 = object.getString("all_type3");
                    add1 = object.getString("shop_address");
                    img1 = object.getString("shop_img_big");
                    if(nowtype2.equals("null")){
                        what =1;
                    }else{
                        if(nowtype3.equals("null")){
                            what =2;
                        }
                        else{
                            what =3;
                        }
                    }

//



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                mHandler.sendMessage(msg);
            }
        }).start();

    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);

    }

    private void finView() {
        btn1=(Button)findViewById(R.id.back3);//退出按钮
        btn=(Button)findViewById(R.id.btn_qh);//取号按钮
        tv_name = (TextView)findViewById(R.id.name);
        add = (TextView)findViewById(R.id.address);
        img = (ImageView)findViewById(R.id.iv_logo);
        tv1 = (TextView)findViewById(R.id.Dtv1);
        tv11 = (TextView)findViewById(R.id.Dtv11);
        tv2 = (TextView)findViewById(R.id.Dtv2);
        tv21 = (TextView)findViewById(R.id.Dtv21);
        tv3 = (TextView)findViewById(R.id.Dtv3);
        tv31 = (TextView)findViewById(R.id.Dtv31);
        ll1 = (LinearLayout)findViewById(R.id.ll1);
        ll2 = (LinearLayout)findViewById(R.id.ll2);
        ll3 = (LinearLayout)findViewById(R.id.ll3);

    }


}
