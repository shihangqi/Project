package com.example.lenovo.inequalitysign.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lenovo.inequalitysign.entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 2016/12/3.
 */
public class CommentAdapter extends BaseAdapter {
    private Context mContext;
    private List<Comment> ls = new ArrayList<>();

    public CommentAdapter(Context context, List<Comment> ls) {
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
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
