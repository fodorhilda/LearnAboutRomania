package com.example.dell.learnaboutromania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button History = (Button)findViewById(R.id.History);
        Button BestPlaces = (Button) findViewById(R.id.BestPlaces);
        Button LearnRomanian = (Button) findViewById(R.id.LearnRomanian);
        Button TraditionalStuffs = (Button) findViewById(R.id.TraditionalStuffs);


        History.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent startIntent= new Intent(getApplicationContext(),History.class);
          //cum sa mergem pe o alta activitate
            startActivity(startIntent);
            }
        });


        /*BestPlaces.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                //cum sa mergem pe o alta activitate
                startActivity(startIntent);
            }
        });

        LearnRomanian.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),  ThirdActivity.class);
                //cum sa mergem pe o alta activitate
                startActivity(startIntent);
            }
        });

        TraditionalStuffs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), TraditionalStuffs.class);
                //cum sa mergem pe o alta activitate
                startActivity(startIntent);
            }
        }); */

        }
    }

