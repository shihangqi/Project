package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.view.ClipViewLayout;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 头像裁剪Activity
 */
public class ClipImageActivity extends AppCompatActivity {

    private ClipViewLayout mCvlayBorder;
    private ImageButton mIBtnBack;
    private Button mBtnCancel;
    private Button mBtnOk;
    private View.OnClickListener mOClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.IBtnClipBack:
                    finish();
                    break;
                case R.id.BtnClipCancel:
                    finish();
                    break;
                case R.id.BtnClipOk:
                    generateUriAndReturn();
                    break;
            }
        }
    };

    /**
     * 生成Uri并且通过setResult返回给打开的activity
     */
    private void generateUriAndReturn() {
        //调用返回剪切图
        Bitmap zoomedCropBitmap;

        zoomedCropBitmap = mCvlayBorder.clip();

        if (zoomedCropBitmap == null) {
            Log.e("android", "zoomedCropBitmap == null");
            return;
        }
        Uri mSaveUri = Uri.fromFile(new File(getCacheDir(), "cropped_" + System.currentTimeMillis() + ".jpg"));
        if (mSaveUri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContentResolver().openOutputStream(mSaveUri);
                if (outputStream != null) {
                    zoomedCropBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException ex) {
                Log.e("android", "Cannot open file: " + mSaveUri, ex);
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            Intent intent = new Intent();
            intent.setData(mSaveUri);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_image);
        findView();
        setListener();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //设置图片资源
        mCvlayBorder.setImageSrc(getIntent().getData());

    }

    private void setListener() {
        //设置点击事件监听器
        mIBtnBack.setOnClickListener(mOClickListener);
        mBtnCancel.setOnClickListener(mOClickListener);
        mBtnOk.setOnClickListener(mOClickListener);
    }

    private void findView() {
        mCvlayBorder = (ClipViewLayout) findViewById(R.id.CvlayClipBorder);
        mIBtnBack = (ImageButton) findViewById(R.id.IBtnClipBack);
        mBtnCancel = (Button) findViewById(R.id.BtnClipCancel);
        mBtnOk = (Button)findViewById(R.id.BtnClipOk);
    }


}
