package com.example.lenovo.inequalitysign.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class DiningActivity_yyt extends Activity{

    private Button btn7;
    private Button btn2;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_dining_yyt);

        btn7=(Button)findViewById(R.id.back7) ;
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(DiningActivity_yyt.this,MainActivity.class);
                startActivity(i3);
            }
        });

        btn2=(Button)findViewById(R.id.ct) ;

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DiningActivity_yyt.this,DiningActivity.class);
                startActivity(i);

            }
        });


        final CustomAdapter adapter = new CustomAdapter(this,R.layout.dining_item);
//为视图控件绑定Adapter
        ListView lv = (ListView)findViewById(R.id.Lv);
        lv.setAdapter(adapter);
        //绑定列表项事件监听器
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {

                Intent intent=new Intent(DiningActivity_yyt.this,DiningInformationActivity.class);
                startActivity(intent);

//点击某一个item时启动新应用
            }
        });
    }


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
