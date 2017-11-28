package com.example.dell.learnaboutromania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class ChooseActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button History = (Button) findViewById(R.id.History);
        Button BestPlaces = (Button) findViewById(R.id.BestPlaces);
        Button LearnRomanian = (Button) findViewById(R.id.LearnRomanian);
        Button TestYourself = (Button) findViewById(R.id.TryYourself);
        Button LogOut = (Button) findViewById(R.id.LogOut);




        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), History.class);
                //cum sa mergem pe o alta activitate
                startActivity(startIntent);
            }
        });


        BestPlaces.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Places.class);
                //cum sa mergem pe o alta activitate
                startActivity(startIntent);
            }
        });

        LearnRomanian.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Online_dictionary.class);
                //cum sa mergem pe o alta activitate
                startActivity(startIntent);
            }
        });

        TestYourself.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), TestYourself.class);
                //cum sa mergem pe o alta activitate
                startActivity(startIntent);
            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                 FirebaseAuth firebaseAuth;
                 firebaseAuth=FirebaseAuth.getInstance();
                 firebaseAuth.signOut();
                 Intent startIntent = new Intent(getApplicationContext(), Log_In.class);
                //cum sa mergem pe o alta activitate

                startActivity(startIntent);
            }
        });












    }
}

