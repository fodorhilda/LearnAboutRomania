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

public class Objects extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseref;
    ListView listviewobjects;
    private ArrayList<String> objectsenglish = new ArrayList<>();
    private ArrayList<String> objectsromanian = new ArrayList<>();
    HashMap<Object, Object> objects;


    String objectsro, objectseng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects);





        objects = DatabaseManager.getObjects();

        for (Object key : objects.keySet()) {
            objectseng = (String) key;
            objectsro = (String) objects.get(key);
            objectsenglish.add(objectseng);
            objectsromanian.add(objectsro);
        }

        listviewobjects = (ListView) findViewById(R.id.ListViewobjects);

        class CustomAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return objectsenglish.size();
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
                text.setText(objectsenglish.get(position));
                text2.setText(objectsromanian.get(position));
                return view;
            }
        }

        CustomAdapter CustomAdapter = new CustomAdapter();
        listviewobjects.setAdapter(CustomAdapter);
    }


}

