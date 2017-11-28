package com.example.dell.learnaboutromania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class
MainActivity extends AppCompatActivity {

    public Button login;
    public Button signup;
    public void init(){
        DatabaseManager.populatefoods();
        DatabaseManager.populatepeople();
        DatabaseManager.populateadjectives();
        DatabaseManager.populateobjects();
        DatabaseManager.populatephrases();
        PlacesDatabaseManager.populatePlaces();


        login=(Button)findViewById(R.id.buttonLogIn);
        signup=(Button)findViewById(R.id.buttonSignUp);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login= new Intent(MainActivity.this,Log_In.class);
                startActivity(login);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup= new Intent(MainActivity.this,SecondActivity.class);
                startActivity(signup);

            }
        });
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        init();
    }
}
