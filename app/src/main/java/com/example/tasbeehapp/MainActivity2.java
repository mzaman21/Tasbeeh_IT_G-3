package com.example.tasbeehapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ScrollView myview;
    GridView TasbeehList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DBhelper Tasbeeh_Db = new DBhelper(MainActivity2.this);

        TasbeehList= findViewById(R.id.TasbeehGrid);

        List<TasbeehModel> list = Tasbeeh_Db.getAllTasbeeh();

//        String[] idate= new String[]{};
//        int[] ikalma=new int[]{};
//        int[] idarood=new int[]{};
//        int[] iastgfar = new int[]{};
//
//        for(int i=0;i<list.size();i++){
//            idate[i]="i";
//            ikalma[i] =0;
//            idarood[i] =0;
//            iastgfar[i] =0;
//        }
//
//        for(int i =0;i<list.size();i++){
//            idate[i]=list.get(i).getToday_date();
//            ikalma[i] = list.get(i).getKalma_Count();
//            idarood[i] = list.get(i).getDarood_Count();
//            iastgfar[i] = list.get(i).getAstgfar_Count();
//        }

        GridAdapter gridAdapter = new GridAdapter(MainActivity2.this,list);
        TasbeehList.setAdapter(gridAdapter);

    }
}