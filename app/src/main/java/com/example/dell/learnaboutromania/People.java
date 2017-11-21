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

public class People extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseref;
    ListView listviewpeople;
    private ArrayList<String> peopleenglish = new ArrayList<>();
    private ArrayList<String> peopleromanian = new ArrayList<>();
    HashMap<Object, Object> people;

    String peopleRo, peopleEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        people = DatabaseManager.getPeople();

        for (Object key : people.keySet()) {
            peopleEng = (String) key;
            peopleRo = (String) people.get(key);
            peopleenglish.add(peopleEng);
            peopleromanian.add(peopleRo);
        }

        listviewpeople = (ListView) findViewById(R.id.ListViewPeople);

        class CustomAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return peopleenglish.size();
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
                text.setText(peopleenglish.get(position));
                text2.setText(peopleromanian.get(position));
                return view;
            }
        }

        CustomAdapter CustomAdapter = new CustomAdapter();
        listviewpeople.setAdapter(CustomAdapter);
    }


}
