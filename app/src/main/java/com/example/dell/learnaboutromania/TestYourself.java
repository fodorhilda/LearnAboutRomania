package com.example.dell.learnaboutromania;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TestYourself extends AppCompatActivity {
    Button answer1, answer2, answer3;
    TextView score, question;
    private  Questions mQuestions= new Questions();
    private String mAnswer;
    private int mScore=0;
    private int mQuestionsLength=mQuestions.mQuestions.length;

    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_yourself2);

        r= new Random();


        answer1= (Button)findViewById(R.id.answer1);
        answer2= (Button)findViewById(R.id.answer2);
        answer3= (Button)findViewById(R.id.answer3);

        score= (TextView) findViewById(R.id.score);
        question= (TextView) findViewById(R.id.question);

        score.setText("Score:"+ mScore);
        updateQuestion(r.nextInt(mQuestionsLength));


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answer1.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score:" + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    TestulSaTerminat();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score:" + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    TestulSaTerminat();
                }
            }
        });


        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText() == mAnswer) {
                    mScore++;
                    score.setText("Score:" + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    TestulSaTerminat();
                }
            }
        });



    }

    private  void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));

        mAnswer= mQuestions.getCorrectAnswer(num);

    }

    private void TestulSaTerminat(){
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(TestYourself.this);
        alertDialogBuilder.setMessage("The test is over! Your score is" + mScore + "points.")
                .setCancelable(false)
                .setPositiveButton("New Test",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), TestYourself.class));
                                finish();
                            }
                        })

        .setNegativeButton("Exit",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int i){
                        finish();
                    }
                });

        AlertDialog alertDialog= alertDialogBuilder.create();
        alertDialog.show();

    }
}
