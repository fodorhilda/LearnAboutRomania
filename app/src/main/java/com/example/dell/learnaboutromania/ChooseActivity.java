package com.example.dell.learnaboutromania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class ChooseActivity extends AppCompatActivity {

   private DatabaseReference databaseref;
    private ListView listviewfood;
    private ArrayList<String> foodenglish = new ArrayList<>();
    private ArrayList<String> foodromanian = new ArrayList<>();

   // private Map<Object, Object> foods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button History = (Button) findViewById(R.id.History);
        Button BestPlaces = (Button) findViewById(R.id.BestPlaces);
        Button LearnRomanian = (Button) findViewById(R.id.LearnRomanian);
        Button TraditionalStuffs = (Button) findViewById(R.id.TraditionalStuffs);


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
                Intent startIntent = new Intent(getApplicationContext(), MapsActivity.class);
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

        TraditionalStuffs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //DatabaseManager databaseManager = new DatabaseManager();
               //// databaseManager.populatefoods();
               // System.out.println(databaseManager.getFoods());

               databaseref = FirebaseDatabase.getInstance().getReference();
//
//                databaseref.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        foods = (Map<Object, Object>) dataSnapshot.getValue();
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });

//                databaseref.addChildEventListener(new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
//                            String foodeng = (String) childSnapshot.getKey();
//                            String foodro = childSnapshot.getValue(String.class);
//
//                            foodromanian.add(foodro);
//                            foodenglish.add(foodeng);
//                        }
//                        // !!!!!.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });


                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);

                //cum sa mergem pe o alta activitate
                startActivity(startIntent);
            }
        });

    }
}

