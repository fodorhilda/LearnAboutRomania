package com.example.dell.learnaboutromania;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView TextViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firebaseAuth = FirebaseAuth.getInstance();

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        TextViewSignin = (TextView) findViewById(R.id.textViewSignin);
        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);
        TextViewSignin.setOnClickListener(this);

    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //nu au scris e-mail
            Toast.makeText(this, "Enter you e-mail", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            // nu au scris parola
            Toast.makeText(this, "Enter you password", Toast.LENGTH_SHORT).show();
            return;

        }

        progressDialog.setMessage("Registering..");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    finish();
                    startActivity(new Intent(getApplicationContext(), ChooseActivity.class));

                }
                 else {
                    Toast.makeText(
                            SecondActivity.this,
                            "Error: " + task.getException().getMessage(),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }

        });
        progressDialog.dismiss();

    }


    @Override
    public void onClick(View v) {

        if (v == buttonRegister) {
            registerUser();
        }

        if (v == TextViewSignin) {
             startActivity(new Intent(this, Log_In.class));

        }
    }
}
