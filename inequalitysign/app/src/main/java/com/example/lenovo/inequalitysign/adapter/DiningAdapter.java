package com.example.lenovo.inequalitysign.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lenovo.inequalitysign.entity.Dining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 2016/12/3.
 */
public class DiningAdapter  extends BaseAdapter {
    private Context mContext;
    private List<Dining> ls = new ArrayList<>();

    public DiningAdapter(Context context, List<Dining> ls) {
        mContext = context;
        this.ls = ls;
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
        return ls.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        return view;
    }
}
