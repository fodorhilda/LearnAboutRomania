package com.example.dell.learnaboutromania;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Log_In extends AppCompatActivity implements View.OnClickListener{

    private Button ButtonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);

        firebaseAuth = FirebaseAuth.getInstance();
        editTextEmail=(EditText) findViewById(R.id.editTextEmail);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
        ButtonSignIn=(Button) findViewById(R.id.buttonLogin);
        textViewSignUp=(TextView) findViewById(R.id.textViewSignup);
        progressDialog = new ProgressDialog(this);
        ButtonSignIn.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);

        if( firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity( new Intent(getApplicationContext(),LogoutActivity.class));
        }

    }

    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
    // verifica daca s-a introdus e-mail si parola
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

        progressDialog.setMessage("Loging in...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    finish();
                    startActivity( new Intent(getApplicationContext(),ThirdActivity.class));
                } else {
                    Toast.makeText(
                            Log_In.this,
                            "Error: " + task.getException().getMessage(),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });




    }

    @Override
    public void onClick(View v) {
        if(v==ButtonSignIn)
        {
            userLogin();
        }
        if(v==textViewSignUp)
        {
            finish(); // inchidem aceasta activitate
            startActivity(new Intent(this, SecondActivity.class )); // trecem inapoi la pagina de Sign Up
        }

    }
}
