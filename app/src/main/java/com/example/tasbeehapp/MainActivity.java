package com.example.tasbeehapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView Kalma,Darood,Astgfar;
    Button savebtn,recordbtn;
    CheckBox KCheck,DCheck,ACheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Kalma = findViewById(R.id.KalamaCount);
        Darood= findViewById(R.id.Daroodcount);
        Astgfar = findViewById(R.id.Astgfarcount);

        KCheck=findViewById(R.id.Kalmacheck);
        DCheck = findViewById(R.id.DaroodCheck);
        ACheck= findViewById(R.id.Astgfarcheck);

        savebtn = findViewById(R.id.Savebtn);
        recordbtn = findViewById(R.id.RecordBtn);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date = new Date();
                //TasbeehModel Today_Tasbeeh;

                SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
                String strDate = formatter.format(date);
                //System.out.println("Date Format with dd MMMM yyyy : "+strDate);
                int KCount,DCount,ACount;

                if(KCheck.isChecked()){
                        KCount = Integer.parseInt(Kalma.getText().toString());
                }
                else{
                    KCount=0;
                }
                if(DCheck.isChecked()){
                    DCount = Integer.parseInt(Darood.getText().toString());
                }
                else{
                    DCount=0;
                }
                if(ACheck.isChecked()){
                    ACount = Integer.parseInt(Astgfar.getText().toString());
                }
                else{
                    ACount=0;
                }
                TasbeehModel Today_Tasbeeh = new TasbeehModel(strDate,KCount,DCount,ACount);
                DBhelper Tasbeeh_Db = new DBhelper(MainActivity.this);
                Tasbeeh_Db.addTasbeeh(Today_Tasbeeh);
            }
        });

        recordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recordbtn.setText("i am clicked");
                Intent mainresultactivity = new Intent(MainActivity.this,MainActivity2.class);
                MainActivity.this.startActivity(mainresultactivity);
            }
        });


    }
}