package com.example.lenovo.inequalitysign.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class DiningActivity extends Activity {

    private Button btn;

    private Button btn2;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dining);


        btn2=(Button)findViewById(R.id.yyt);



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DiningActivity.this,ListActivity_yyt.class);
                startActivity(i);

            }
        });


        btn=(Button)findViewById(R.id.back1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(DiningActivity.this,MainActivity.class);
                startActivity(i5);
            }
        });
//创建Adapter
        final CustomAdapter adapter = new CustomAdapter(this,R.layout.dining_item);
//为视图控件绑定Adapter
        ListView lv = (ListView)findViewById(R.id.Lv);
        lv.setAdapter(adapter);
        //绑定列表项事件监听器
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {

                Intent intent=new Intent(DiningActivity.this,DiningInformationActivity.class);
                startActivity(intent);

//点击某一个item时启动新应用
            }
        });
    }
    /**
     * 内部类，自定义适配器
     */
    private class CustomAdapter extends BaseAdapter {
        private Context mContext;
        //上下文环境
        private int mResource;
        //待加载的列表项item布局资源
        private String[] mText = {"   如果你还无法简介的表达你的想法，那只说明你还不够了解他",
                "   如果你还无法简介的表达你的想法，那只说明你还不够了解他", "   如果你还无法简介的表达你的想法，那只说明你还不够了解他", "   如果你还无法简介的表达你的想法，那只说明你还不够了解他",
                "   如果你还无法简介的表达你的想法，那只说明你还不够了解他","   如果你还无法简介的表达你的想法，那只说明你还不够了解他",
                "   如果你还无法简介的表达你的想法，那只说明你还不够了解他","   如果你还无法简介的表达你的想法，那只说明你还不够了解他","    如果你还无法简介的表达你的想法，那只说明你还不够了解他"};
        private int[] mImage = {R.drawable.f,R.drawable.f,
                R.drawable.f,R.drawable.f,R.drawable.f,R.drawable.f,
                R.drawable.f,R.drawable.f,R.drawable.f
        };
        public CustomAdapter(Context context, int resource) {
            mContext = context;
            mResource = resource;
        }
        public int getCount() {
            if (mImage.length == mText.length) {
                return mText.length;
            }
            return 0;
        }
        public Object getItem(int position) {
            return null;
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
//加载视图页面
            if (null == convertView) {
                convertView = getLayoutInflater().inflate(mResource, null);
            }
//绘制视图中的每一项
            ImageView imgView = (ImageView)convertView.findViewById(R.id.TvName);
            imgView.setImageResource(mImage[position]);
            TextView txtView = (TextView)convertView.findViewById(R.id.TvAuther);
            txtView.setText(mText[position]);
//返回视图对象
            return convertView;
        }
    }
}
