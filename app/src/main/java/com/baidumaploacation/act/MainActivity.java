package com.baidumaploacation.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baidumaploacation.R;
import com.baidumaploacation.adapter.ListAdapter;
import com.baidumaploacation.routeplan.act.RoutePlanAct;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {


    private ListView listView;
    private ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ListAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        Intent intent = new Intent();
        switch (pos) {
            case 0:
                intent.setClass(this, LocAct.class);
                break;
            case 1:
                intent.setClass(this, CompassAct.class);
                break;
            case 2:
                intent.setClass(this, PoiSearchAct.class);
                break;
            case 3:
                intent.setClass(this, BusLineSearchAct.class);
                break;
            case 4:
                intent.setClass(this, RoutePlanAct.class);
                break;
        }
        startActivity(intent);
    }
}
