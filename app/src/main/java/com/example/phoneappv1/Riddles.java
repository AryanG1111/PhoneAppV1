package com.example.phoneappv1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Riddles extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText textbox;
    TextView question;
    Button confirm_button;
    Button exit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.riddle_question);
            textbox = findViewById(R.id.riddleAnswer);
            question = findViewById(R.id.txtQuestion);
            exit_button = findViewById(R.id.exitButton);
            confirm_button = findViewById(R.id.btnSubmit);
            confirm_button.setOnClickListener(this);
            exit_button.setOnClickListener(this);
            BufferedReader br = new BufferedReader(new InputStreamReader(this.getAssets().open("riddles.txt")));
            RiddleReader rr = new RiddleReader(br);
            int num = (int) (Math.random()*5);
            if (num == 5)
                num = 4;
            String q = rr.getRiddle(num).getQuestion();
            String ans = rr.getRiddle(num).getAns();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }


    public void onClick(View view) {
        String text;
        if(textbox.getText() != null)
            text = textbox.getText().toString();


    }
}
