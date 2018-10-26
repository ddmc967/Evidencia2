package com.example.daniel.evidencia2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.daniel.evidencia2.usuario;

import java.util.ArrayList;

import static com.example.daniel.evidencia2.R.*;



public class RecyclerViewActivity extends Activity {

    private View mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public RecyclerViewActivity() {
        mRecyclerView = this.<View>findViewById(id.RecyclerView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<usuario> curps = usuario.getCurps(this);
        mAdapter = new AdapterRecyclerViewCurp(curps);

        mRecyclerView.setAdapter(mAdapter);
    }

}