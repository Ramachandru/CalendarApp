package com.ramachandran.calendarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CalderAdapter calderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView calendarRecycle=(RecyclerView)findViewById(R.id.calerRecycler);
        calderAdapter = new CalderAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        calendarRecycle.setLayoutManager(linearLayoutManager);
        calendarRecycle.setAdapter(calderAdapter);
    }

}
