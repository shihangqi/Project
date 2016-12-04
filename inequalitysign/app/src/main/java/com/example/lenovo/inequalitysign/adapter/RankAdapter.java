package com.example.lenovo.inequalitysign.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lenovo.inequalitysign.entity.Rank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 2016/12/3.
 */
public class RankAdapter extends BaseAdapter {
    private Context context;
    private List<Rank> ls = new ArrayList<>();

    public RankAdapter(Context context, List<Rank> ls) {
        this.context = context;
        this.ls = ls;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
