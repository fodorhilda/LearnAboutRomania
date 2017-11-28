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

public class Phrases extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseref;
    ListView listviewphrases;
    private ArrayList<String> phrasesenglish = new ArrayList<>();
    private ArrayList<String> phrasesromanian = new ArrayList<>();
    HashMap<Object, Object> phrases;


    String phrasesro, phraseseng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);





        phrases = DatabaseManager.getPhrases();

        for (Object key : phrases.keySet()) {
            phraseseng = (String) key;
            phrasesro = (String) phrases.get(key);
            phrasesenglish.add(phraseseng);
            phrasesromanian.add(phrasesro);
        }

        listviewphrases = (ListView) findViewById(R.id.ListViewphrases);

        class CustomAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return phrasesenglish.size();
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
                text.setText(phrasesenglish.get(position));
                text2.setText(phrasesromanian.get(position));
                return view;
            }
        }

        CustomAdapter CustomAdapter = new CustomAdapter();
        listviewphrases.setAdapter(CustomAdapter);
    }


}
