package com.example.dell.learnaboutromania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Food extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseref;
    ListView listviewfood;
    private ArrayList<String> foodenglish = new ArrayList<>();
    private ArrayList<String> foodromanian = new ArrayList<>();
    HashMap<Object, Object> foods;


    String foodro, foodeng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        //  database = FirebaseDatabase.getInstance();
        // databaseref = database.getReference("Food");

      /*  databaseref.addValueEventListener(new ValueEventListener() {
                                              @Override
                                              public void onDataChange(DataSnapshot dataSnapshot) {
                                                  foods = (HashMap<Object, Object>) dataSnapshot.getValue();
                                              }

                                              @Override
                                              public void onCancelled(DatabaseError databaseError) {

                                              }
                                          });

*/
        foods = DatabaseManager.getFoods();

        for (Object key : foods.keySet()) {
            foodeng = (String) key;
            foodro = (String) foods.get(key);
            foodenglish.add(foodeng);
            foodromanian.add(foodro);
        }

        listviewfood = (ListView) findViewById(R.id.ListViewFood);

        class CustomAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return foodenglish.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            public View getView(int position, View convertView, ViewGroup parent) {

                View view = getLayoutInflater().inflate(R.layout.dictionary, null);

                TextView text = (TextView) view.findViewById(R.id.textView5);
                TextView text2 = (TextView) view.findViewById(R.id.textView6);
                text.setText(foodenglish.get(position));
                text2.setText(foodromanian.get(position));
                return view;
            }
        }

        CustomAdapter CustomAdapter = new CustomAdapter();
        listviewfood.setAdapter(CustomAdapter);
    }


}



