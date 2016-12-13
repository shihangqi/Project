package com.example.lenovo.inequalitysign.adapter;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.util.Log;

import com.example.lenovo.inequalitysign.Utils.Utils;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

/**
 * Created by ff on 2016/11/29.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(getApplicationContext());
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
        String device_token = mPushAgent.getRegistrationId();
        Utils.push_id = device_token;
        UmengMessageHandler messageHandler = new UmengMessageHandler(){
            @Override
            public Notification getNotification(Context var1, UMessage var2) {

                Utils.now = var2.text.substring(var2.text.indexOf("到")+1,var2.text.indexOf("号"));

                return null;
            }
        };
        mPushAgent.setMessageHandler(messageHandler);

    }

    private static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs();
         // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());

    }
}
