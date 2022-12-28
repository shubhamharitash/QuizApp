package com.example.quizapp;

import static com.example.quizapp.MainActivity.SCORE_CARD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_board);
        textView=findViewById(R.id.textView2);
        Intent intent=getIntent();
       String score= intent.getStringExtra(SCORE_CARD);
       textView.setText("YOUR SCORE ="+score);
    }
}