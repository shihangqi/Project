package com.example.lenovo.inequalitysign.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.inequalitysign.R;

import com.example.lenovo.inequalitysign.Utils.Utils;

import com.example.lenovo.inequalitysign.Utils.QQUtil;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.http.Https;
import com.example.lenovo.inequalitysign.http.Httpss;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    public static String mAppid;
    public static QQAuth mQQAuth;
    private UserInfo mInfo;
    private Tencent mTencent;
    private final String APP_ID = "1105749707";
    private  String response_server = "";//QQ登陆后调用程序得到的响应
    private ImageButton btn;
    private EditText et_te1;
    private EditText et_cord;
    private Button get_cord;
    private Button btn_login;
    private TextView now;
    private ImageButton btn_wb;
    private ImageButton btn_wx;
    private String iPhone;
    private String iCord;
    private int time = 60;
    private String openid;
    private boolean flag = true;
    private Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(response_server.equals("loginfail")){
                Log.e("--------------石航琪失败",response_server);
                Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this,LoginActivity.class);
                startActivity(i);
            }else{
                Log.e("-----石航琪成功",response_server);
                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                Utils.id = response_server;
                Intent i = new Intent(LoginActivity.this,AlreadyLogin.class);
                Log.e("Utils.flag",Utils.flag+"");
                startActivity(i);
            }
        }
    };
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.loginB1:
                    Utils.flag = 4;
                    Intent i = new Intent();
                    i.setClass(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.loginB2:
                    if(!TextUtils.isEmpty(et_te1.getText().toString().trim())){
                        if(et_te1.getText().toString().trim().length()==11){
                            iPhone = et_te1.getText().toString().trim();
                            SMSSDK.getVerificationCode("86",iPhone);
                            et_cord.requestFocus();
                            get_cord.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(LoginActivity.this, "请输入完整电话号码", Toast.LENGTH_LONG).show();
                            et_te1.requestFocus();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "请输入您的电话号码", Toast.LENGTH_LONG).show();
                        et_te1.requestFocus();
                    }
                    break;
                case R.id.loginB3:
//                    //验证  验证码是否正确 如果正确跳已经登陆界面
//                    if(!TextUtils.isEmpty(et_cord.getText().toString().trim())){
//                        if(et_cord.getText().toString().trim().length()==4){
//                            iCord = et_cord.getText().toString().trim();
//                            SMSSDK.submitVerificationCode("86", iPhone, iCord);
//                            flag = false;
//                        }else{
//                            Toast.makeText(LoginActivity.this, "请输入完整验证码", Toast.LENGTH_LONG).show();
//                            et_cord.requestFocus();
//                        }
//                    }else{
//                        Toast.makeText(LoginActivity.this, "请输入验证码", Toast.LENGTH_LONG).show();
//                        et_cord.requestFocus();
//                    }
                    break;
                case R.id.loginB4:
                    final Context context = LoginActivity.this;
                    final Context ctxContext = context.getApplicationContext();
                    mAppid = APP_ID;
                    mQQAuth = QQAuth.createInstance(mAppid, ctxContext);
                    mTencent = Tencent.createInstance(mAppid, LoginActivity.this);
                    Context c = view.getContext();
                    Class<?> cls = null;
                    switch (view.getId()) {
                        case R.id.loginB4:
                            onClickLogin();
                            return;
                    }
                    if (cls != null) {
                        Intent intent = new Intent(c, cls);
                        c.startActivity(intent);
                    }
                    break;
                case R.id.loginB5:
                    //用微信登陆
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        setOnClick();
        init();
    }

    private void init() {
        SMSSDK.initSDK(this, "1904c31d29a41", "e73946a5b939c0626b3c83b92fea9c0d");
        EventHandler eh=new EventHandler(){



            @Override

            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                handler.sendMessage(msg);
            }

        };
        SMSSDK.registerEventHandler(eh);
    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        get_cord.setOnClickListener(mListener);
        btn_login.setOnClickListener(mListener);
        btn_wb.setOnClickListener(mListener);
        btn_wx.setOnClickListener(mListener);

    }

    private void findView() {
        btn = (ImageButton)findViewById(R.id.loginB1);//退出按钮
        et_te1 = (EditText)findViewById(R.id.et_tel);//输入手机号
        et_cord = (EditText)findViewById(R.id.et_pwd);//输入验证码
        get_cord = (Button) findViewById(R.id.loginB2);
        now = (TextView) findViewById(R.id.now);
        btn_login = (Button)findViewById(R.id.loginB3);//登陆按钮
        btn_wb = (ImageButton)findViewById(R.id.loginB4);//微博登陆
        btn_wx = (ImageButton)findViewById(R.id.loginB5);//微信登陆


    }
    @Override
    protected void onResume() {
        Log.d(TAG, "-->onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "-->onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "-->onStop");
        super.onStop();
    }

    private void updateUserInfo() {
        if (mQQAuth != null && mQQAuth.isSessionValid()) {
            IUiListener listener = new IUiListener() {

                @Override
                public void onError(UiError e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onComplete(final Object response) {
                    Message msg = new Message();
                    msg.obj = response;
                    msg.what = 0;
                    mHandler.sendMessage(msg);
                    new Thread() {

                        @Override
                        public void run() {
                            JSONObject json = (JSONObject) response;
                            if (json.has("figureurl")) {
                                Bitmap bitmap = null;
                                try {
                                    bitmap = QQUtil.getbitmap(json
                                            .getString("figureurl_qq_2"));
                                } catch (JSONException e) {

                                }
                                Message msg = new Message();
                                msg.obj = bitmap;
                                msg.what = 1;
                                mHandler.sendMessage(msg);
                            }
                        }

                    }.start();
                }

                @Override
                public void onCancel() {
                }
            };
            mInfo = new UserInfo(this, mQQAuth.getQQToken());
            mInfo.getUserInfo(listener);

        } else {
//            mUserInfo.setText("");
//            mUserInfo.setVisibility(android.view.View.GONE);
//            mUserLogo.setVisibility(android.view.View.GONE);
        }
    }

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                JSONObject response = (JSONObject) msg.obj;
                if (response.has("nickname")) {
//                    try {
////                        mUserInfo.setVisibility(android.view.View.VISIBLE);
////                        mUserInfo.setText(response.getString("nickname"));
//                    } catch (JSONException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                }
            } else if (msg.what == 1) {
                Bitmap bitmap = (Bitmap) msg.obj;
//                mUserLogo.setImageBitmap(bitmap);
//                mUserLogo.setVisibility(android.view.View.VISIBLE);
            }
        }

    };

    private void onClickLogin() {
        if (!mQQAuth.isSessionValid()) {
            IUiListener listener = new BaseUiListener() {
                @Override
                protected void doComplete(JSONObject values) {
                    updateUserInfo();
                }
            };
            mQQAuth.login(this, "all", listener);
            mTencent.login(this, "all", listener);
        } else {
            mQQAuth.logout(this);
            updateUserInfo();
        }
    }

    /**
     *QQ登陆成功后调用这个类
     */
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            String s = response.toString();
            try {
                JSONObject json = new JSONObject(s);
                openid = json.getString("openid");
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        NameValuePair pair = new BasicNameValuePair("user_id", openid);
                        Log.e("++++++++",pair.getName().toString());
                        Log.e("++++++++",pair.getValue().toString());
                        Log.e("++++++++",pair.toString());
                        Httpss h = new Httpss();
                        response_server = h.setAndGet("http://10.7.88.34:8090/user/login",pair);
                        Log.e("++++++++++=",response_server);
                        Message msg = new Message();
                        handler1.sendMessage(msg);

                    }
                }).start();

            } catch (JSONException e) {
                e.printStackTrace();
            }
            doComplete((JSONObject) response);
        }

        protected void doComplete(JSONObject values) {

        }

        @Override
        public void onError(UiError e) {
            QQUtil.toastMessage(LoginActivity.this, "onError: " + e.errorDetail);
            QQUtil.dismissDialog();
        }

        @Override
        public void onCancel() {
            QQUtil.toastMessage(LoginActivity.this, "onCancel: ");
            QQUtil.dismissDialog();
        }
    }

    private void reminderText() {
        now.setVisibility(View.VISIBLE);
        handlerText.sendEmptyMessageDelayed(1, 1000);
    }



    Handler handlerText =new Handler(){

        public void handleMessage(Message msg) {
            if(msg.what==1){
                if(time>0){
                    now.setText("验证码已发送"+time+"秒");
                    time--;
                    handlerText.sendEmptyMessageDelayed(1, 1000);
                }else{
                    now.setText("提示信息");
                    time = 60;
                    now.setVisibility(View.GONE);
                    get_cord.setVisibility(View.VISIBLE);
                }

            }else{
                et_cord.setText("");
                now.setText("提示信息");
                time = 60;
                now.setVisibility(View.GONE);
                get_cord.setVisibility(View.VISIBLE);
            }

        };

    };
    /**
     * 短信验证成功后 调用
     */

    Handler handler=new Handler(){


        @Override

        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            Log.e("event", "event="+event);
            if (result == SMSSDK.RESULT_COMPLETE) {
                //短信注册成功后，返回MainActivity,然后提示新好友
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码成功,验证通过
                    Toast.makeText(getApplicationContext(), "验证码校验成功", Toast.LENGTH_SHORT).show();
                    handlerText.sendEmptyMessage(2);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Httpss h = new Httpss();
                            NameValuePair pair = new BasicNameValuePair("user_tel",et_te1.getText().toString());
                            Log.e("++++++++",pair.getName().toString());
                            Log.e("++++++++",pair.getValue().toString());
                            Log.e("++++++++",pair.toString());
                            response_server = h.setAndGet("http://10.7.88.34:8090/user/login",pair);
                            Log.e("++++",response_server);
                        }
                    }).start();
                    Message msg1 =new Message();
                    handler1.sendMessage(msg1);

                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){//服务器验证码发送成功
                    reminderText();
                    Toast.makeText(getApplicationContext(), "验证码已经发送", Toast.LENGTH_SHORT).show();
                }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){//返回支持发送验证码的国家列表
                    Toast.makeText(getApplicationContext(), "获取国家列表成功", Toast.LENGTH_SHORT).show();
                }
            } else {
                if(flag){
                    get_cord.setVisibility(View.VISIBLE);
                    Toast.makeText(LoginActivity.this, "验证码获取失败，请重新获取", Toast.LENGTH_SHORT).show();
                    et_te1.requestFocus();
                }else{
                    ((Throwable) data).printStackTrace();
                    Toast.makeText(LoginActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    et_cord.selectAll();
                }

            }

        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }
}
