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

public class Adjectives extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseref;
    ListView listviewadjectives;
    private ArrayList<String> adjectivesenglish = new ArrayList<>();
    private ArrayList<String> adjectivesromanian = new ArrayList<>();
    HashMap<Object, Object> adjectives;


    String adjectivesro, adjectiveseng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjectives);





        adjectives = DatabaseManager.getAdjectives();

        for (Object key : adjectives.keySet()) {
            adjectiveseng = (String) key;
            adjectivesro = (String) adjectives.get(key);
            adjectivesenglish.add(adjectiveseng);
            adjectivesromanian.add(adjectivesro);
        }

        listviewadjectives = (ListView) findViewById(R.id.ListViewadjectives);

        class CustomAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return adjectivesenglish.size();
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
                text.setText(adjectivesenglish.get(position));
                text2.setText(adjectivesromanian.get(position));
                return view;
            }
        }

        CustomAdapter CustomAdapter = new CustomAdapter();
        listviewadjectives.setAdapter(CustomAdapter);
    }


}
