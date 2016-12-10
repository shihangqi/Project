package com.example.lenovo.inequalitysign.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.entity.Scene;

import java.util.List;

/**
 * Created by ff on 2016/12/10.
 */
public class MasonryAdapter   extends RecyclerView.Adapter<MasonryAdapter.MasonryView>{
    private List<Scene> ls ;

    public MasonryAdapter(List<Scene> ls) {
        this.ls = ls;
    }

    @Override
    public MasonryAdapter.MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.masonry_item, parent, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryAdapter.MasonryView holder, int position) {
//        holder.imageView.setImageResource(ls.get(position).getImg());
        holder.textView.setText(ls.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }
    public static class MasonryView extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.masonry_item_img );
            textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
        }

    }

}
