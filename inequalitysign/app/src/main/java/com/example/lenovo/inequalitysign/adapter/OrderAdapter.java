package com.example.lenovo.inequalitysign.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.entity.Order;
import com.example.lenovo.inequalitysign.http.Httpss;
import com.example.lenovo.inequalitysign.ui.DiningInformationActivity;
import com.example.lenovo.inequalitysign.ui.MineOrderActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 2016/12/3.
 */
public class OrderAdapter extends BaseAdapter {

    private String u =Utils.USER_URL+"deleteorder";
    private DisplayImageOptions options;
    private List<Order> ls = new ArrayList<>();
    private Context context;
    private String shop_id="";
    private String type="";
    private String num="";
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.mine_orderB2:
                    Intent ii = new Intent();
                    ii.setClass(context, MineOrderActivity.class);
                    ii.putExtra("Id",shop_id);
                    ii.putExtra("Type",type);
                    ii.putExtra("Num",num);
                    context.startActivity(ii);
                    break;
                case R.id.mine_orderB3:
                    Intent i = new Intent();
                    i.setClass(context,DiningInformationActivity.class);
                    i.putExtra("Id",shop_id);
                    context.startActivity(i);
                    break;
            }
        }
    };

    public OrderAdapter(Context context,List<Order> ls) {
        this.ls = ls;
        this.context = context;
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

    @Override
    public int getCount() {
        return ls.size();
    }

    @Override
    public Object getItem(int i) {
        return ls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.order_item,null);
        }
        Order order = ls.get(i);
        TextView tv_name = (TextView)view.findViewById(R.id.tv_name);
        ImageView tv_url = (ImageView)view.findViewById(R.id.tv_url);
        TextView tv_num = (TextView)view.findViewById(R.id.tv_num);
        ImageButton  btn_delete = (ImageButton)view.findViewById(R.id.mine_orderB2);
        Button again = (Button)view.findViewById(R.id.mine_orderB3);
        TextView status = (TextView)view.findViewById(R.id.tv_type);
        shop_id = order.getShop_id();
        type = order.getType();
        num = order.getNum();
        tv_name.setText(order.getTitle());
        tv_num.setText(order.getNum());
        ImageLoader.getInstance().displayImage(order.getUrl(),tv_url);
        if(order.getStatus() == "1"){
            status.setText("未消费");
        }else{
            status.setText("已消费");
        }


        return view;
    }
}
