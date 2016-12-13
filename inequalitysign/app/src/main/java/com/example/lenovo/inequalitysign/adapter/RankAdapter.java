package com.example.lenovo.inequalitysign.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.entity.Rank;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 2016/12/3.
 */
public class RankAdapter extends BaseAdapter {
    private DisplayImageOptions options;
    private Context context;
    private List<Rank> ls = new ArrayList<>();

    public RankAdapter(Context context, List<Rank> ls) {
        this.context = context;
        this.ls = ls;
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
            view = LayoutInflater.from(context).inflate(R.layout.rank_item,null);
        }
        TextView tv_num = (TextView)view.findViewById(R.id.tv);
        ImageView iv = (ImageView)view.findViewById(R.id.iv11);
        TextView tv_shop = (TextView)view.findViewById(R.id.tv1);
        TextView tv_address = (TextView)view.findViewById(R.id.tv2);
        TextView tv_count = (TextView)view.findViewById(R.id.tv3);
        Rank rank = ls.get(i);
        tv_num.setText(++i +"");
        tv_shop.setText(rank.getShop_name());
        tv_address.setText(rank.getAddress());
        tv_count.setText(rank.getWait_num());
        ImageLoader.getInstance().displayImage(rank.getUrl(),iv);
        return view;
    }
}
