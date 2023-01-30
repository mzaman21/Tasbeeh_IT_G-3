package com.example.tasbeehapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ScrollView myview;
    ListView TasbeehList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DBhelper Tasbeeh_Db = new DBhelper(MainActivity2.this);

        List<TasbeehModel> list = Tasbeeh_Db.getAllTasbeeh();
        ArrayAdapter arrayAdapter = new ArrayAdapter<TasbeehModel>(MainActivity2.this, android.R.layout.simple_list_item_1,list);
        TasbeehList.setAdapter(arrayAdapter);
    }
}