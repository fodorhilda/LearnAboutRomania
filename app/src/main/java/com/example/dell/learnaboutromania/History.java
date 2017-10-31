package com.example.dell.learnaboutromania;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class History extends AppCompatActivity {
    private RadioButton radiobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        radiobutton = (RadioButton) findViewById(R.id.InEnglishBtn);
        radiobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiobutton.isChecked()) {

                    String history = "https://en.wikipedia.org/wiki/History_of_Romania";
                    Uri webaddress = Uri.parse(history);
                    Intent gotoWikipedia = new Intent(Intent.ACTION_VIEW, webaddress);
                    startActivity(gotoWikipedia);
                } else {
                    String history = "https://ro.wikipedia.org/wiki/Istoria_Rom%C3%A2niei";
                    Uri webaddress = Uri.parse(history);

                    Intent gotoWikipedia = new Intent(Intent.ACTION_VIEW, webaddress);
                    startActivity(gotoWikipedia);
                }
            }
        });
    }
}
