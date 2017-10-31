package com.example.dell.learnaboutromania;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class History extends AppCompatActivity {
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        checkbox = (CheckBox) findViewById(R.id.checkBox);
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox.isChecked()) {
                    String history = "https://en.wikipedia.org/wiki/History_of_Romania";
                    Uri webaddress = Uri.parse(history);
                    Intent gotoWikipedia = new Intent(Intent.ACTION_VIEW, webaddress);
                } else {
                    String history = "https://ro.wikipedia.org/wiki/Istoria_Rom%C3%A2niei";
                    Uri webaddress = Uri.parse(history);

                    Intent gotoWikipedia = new Intent(Intent.ACTION_VIEW, webaddress);
                }
            }
        });
    }
}
