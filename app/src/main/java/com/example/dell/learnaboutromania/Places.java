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
            R.drawable.castelulpeles,
            R.drawable.cazaneledunarii,
            R.drawable.cetateaalbaiulia,
            R.drawable.cimitirulvesel,
            R.drawable.clujnapoca,
            R.drawable.deltadunarii,
            R.drawable.laculsfantaana,
            R.drawable.muntiirodnei,
            R.drawable.rosiamontana,
            R.drawable.sibiu,
            R.drawable.sighetulmarmatiei,
            R.drawable.sighisoara,
            R.drawable.suceava,
            R.drawable.transfagarasan,
    };


    private String[] words = {"Brasov", "Castelul Peles", "Cazanele Dunarii", "Cetatea Alba Iulia",
            "Cimitirul Vesel", "Cluj-Napoca", "Delta Dunarii", "Lacul Sfanta Ana", "Muntii Rodnei",
            "Rosia Montana", "Sibiu", "Sighetul Marmatiei", "Sighisoara", "Suceava", "Transfagarasan"};


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
                try {
                    ImageView image = (ImageView) view.findViewById(R.id.imageView3);
                    TextView text = (TextView) view.findViewById(R.id.textView5);
                    TextView descriptionTextView = (TextView) view.findViewById(R.id.description);

                    Button button = (Button) view.findViewById(R.id.button2);
                    final String name = words[position];
                    final City city = PlacesDatabaseManager.getCityByName(name);
                    final String description = city.getDescription();

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent startIntent = new Intent(getApplicationContext(), MapsActivity.class);
                            startIntent.putExtra("Longitude", city.getCoordinates().getLongitude());
                            startIntent.putExtra("Latitude", city.getCoordinates().getLatitude());
                            startActivity(startIntent);

                        }

                    });


                    image.setImageResource(images[position]);
                    text.setText(name);
                    descriptionTextView.setText(description);
                } catch (Exception ex) {
                    System.out.println();
                }
                return view;
            }


        }


        CustomAdapter customAdapter = new CustomAdapter();
        Places1.setAdapter(customAdapter);

    }
}


