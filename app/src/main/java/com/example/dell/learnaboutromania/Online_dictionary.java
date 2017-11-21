package com.example.dell.learnaboutromania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Online_dictionary extends AppCompatActivity {


    private ListView listViewDictionary;
    private int[] images = {
            R.drawable.food,
            R.drawable.people,
            R.drawable.clothes,
            R.drawable.objects,
            R.drawable.slang
    };

    private String[] words =
            {"Food&Drink", "People&Places", "Clothes", "Object&Things", "Slang words"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_dictionary);

        listViewDictionary = (ListView) findViewById(R.id.ListViewDictionary);

        class CustomAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = getLayoutInflater().inflate(R.layout.layout_for_dictionary, null);
                ImageView image = (ImageView) view.findViewById(R.id.imageView);
                TextView text = (TextView) view.findViewById(R.id.textView3);
                image.setImageResource(images[position]);
                text.setText(words[position]);
                return view;
            }
        }

        CustomAdapter customAdapter = new CustomAdapter();
        listViewDictionary.setAdapter(customAdapter);

        listViewDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition = position;

                switch (itemPosition) {

                    case 0:
                        Intent food = new Intent(getApplicationContext(), Food.class);
                        startActivity(food);
                        break;
                   case 1:
                        Intent people = new Intent(getApplicationContext(), People.class);
                        startActivity(people);
                        break;
                  /*  case 2:
                        Intent clothes = new Intent(this, Clothes.class);
                        startActivity(clothes);
                    case 3:
                        Intent object = new Intent(this, Objects.class);
                        startActivity(object);
                        break;
                    case 4:
                        Intent slang = new Intent(this, Slang.class);
                        startActivity(slang);
                        break;
                }*/
                }


            }
        });
    }
}