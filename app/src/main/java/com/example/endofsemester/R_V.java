package com.example.endofsemester;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class R_V extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r__v2);
        initRecyclerView();
    }





    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);
        Recycleview adapter = new Recycleview();
        recyclerView.setAdapter(adapter);
    }


}
