package com.example.dell.learnaboutromania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.learnaboutromania.model.City;

public class Places extends AppCompatActivity {
    // private Button button2;

    private ListView Places1;
    private int[] images = {
            R.drawable.brasov,
            R.drawable.muntiirodnei,
            R.drawable.sighetulmarmatiei,
            R.drawable.laculsfantaana,
            R.drawable.suceava,
            R.drawable.deltadunarii,
            R.drawable.transfagarasan,
            R.drawable.sighisoara,
            R.drawable.sibiu,
            R.drawable.cimitirulvesel,
            R.drawable.rosiamontana,
            R.drawable.clujnapoca,
            R.drawable.cazaneledunarii,
            R.drawable.cetateaalbaiulia,
            R.drawable.castelulpeles
    };


    private String[] words =
            {"Brasov", "Muntii_Rodnei", "Sighetul_Mrmatiei", "Lacul_Sfanta_Ana", "Suceava",
                    "Delta_Dunarii", "Transfagarasan", "Sighisoara", "Sibiu", "Cimitirul_vesel",
                    "Rosia_montana", "Cluj_napoca", "Cazanele_dunarii", "Cetatea_albaiulia",
                    "Castelul_peles"
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        Places1 = (ListView) findViewById(R.id.Places1);


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
                View view = getLayoutInflater().inflate(R.layout.layout_for_places, null);
                ImageView image = (ImageView) view.findViewById(R.id.imageView3);
                TextView text = (TextView) view.findViewById(R.id.textView5);
                Button button = (Button) view.findViewById(R.id.button2);
                final String name= words[position];

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        City city =PlacesDatabaseManager.getCityByName(name);
                        Intent startIntent = new Intent(getApplicationContext(), MapsActivity.class);
                        startIntent.putExtra("Longitude",city.getCoordinates().getLongitude());
                        startIntent.putExtra("Latitude",city.getCoordinates().getLatitude());
                        startActivity(startIntent);

                    }

                });


                image.setImageResource(images[position]);
                text.setText(name);
                return view;
            }


        }


        CustomAdapter customAdapter = new CustomAdapter();
        Places1.setAdapter(customAdapter);

    }
}


