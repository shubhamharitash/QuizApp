package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

public static final String SCORE_CARD="com.example.quizapp.SCORE_CARD";

private TextView textView;
private Button yes;
private Button no;
private int index=0;
private  int score=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        yes=findViewById(R.id.button);
        no=findViewById(R.id.button2);

        String questions[]={"Are you mad?","Are you genius?","Do you belongs to india?","Is india Supreme?"};
        boolean answers[]={false,true,true,true};
      textView.setText(questions[0]);


        Intent intent=new Intent(this,ScoreBoard.class);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<questions.length) {
                    if (answers[index])
                        score++;
                    index++;
                    if (index<questions.length) {
                        textView.setText(questions[index]);
                    }else {
                        Toast.makeText(MainActivity.this, "Score="+score, Toast.LENGTH_SHORT).show();

                        intent.putExtra(SCORE_CARD,score+"/"+questions.length);
                        startActivity(intent);
                    }
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<questions.length) {
                    if (!answers[index])
                        score++;
                    index++;
                    if (index<questions.length) {
                        textView.setText(questions[index]);
                    }else {
                        Toast.makeText(MainActivity.this, "Score="+score, Toast.LENGTH_SHORT).show();
                        intent.putExtra(SCORE_CARD,score+"/"+questions.length);
                        startActivity(intent);

                    }
                }
            }
        });

    }
}