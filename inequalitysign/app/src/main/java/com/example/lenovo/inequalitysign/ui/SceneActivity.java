package com.example.lenovo.inequalitysign.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;


import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.adapter.MasonryAdapter;
import com.example.lenovo.inequalitysign.entity.Scene;

import java.util.ArrayList;
import java.util.List;

public class SceneActivity extends AppCompatActivity {
    private List<Scene> ls = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        recyclerView= (RecyclerView) findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        initData();

        MasonryAdapter adapter=new MasonryAdapter(ls);
        recyclerView.setAdapter(adapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(15);
        recyclerView.addItemDecoration(decoration);
    }

    private void initData() {
        ls.add(new Scene(R.drawable.sc_1,"1"));
        ls.add(new Scene(R.drawable.sc_2,"2"));
        ls.add(new Scene(R.drawable.sc_3,"3"));
        ls.add(new Scene(R.drawable.sc_4,"4"));
        ls.add(new Scene(R.drawable.sc_5,"5"));
        ls.add(new Scene(R.drawable.sc_6,"6"));
    }
}
