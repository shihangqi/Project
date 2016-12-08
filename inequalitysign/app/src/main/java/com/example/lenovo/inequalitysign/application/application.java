package com.example.lenovo.inequalitysign.application;

import android.app.Application;
import android.util.Log;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by Administrator on 2016/12/7.
 */
public class application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d("mytoken:",deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.d("myerror:","123456");
            }
        });
    }
}
