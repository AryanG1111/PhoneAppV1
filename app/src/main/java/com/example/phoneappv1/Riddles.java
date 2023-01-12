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
    TextView ansBox;
    Button confirm_button;
    Button exit_button;
    String ans;
    String q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.riddle_question);
            textbox = findViewById(R.id.riddleAnswer);
            question = findViewById(R.id.txtQuestion);
            ansBox = findViewById(R.id.txtAnswer);
            exit_button = findViewById(R.id.exitButton);
            confirm_button = findViewById(R.id.btnSubmit);
            BufferedReader br = new BufferedReader(new InputStreamReader(this.getAssets().open("riddles.txt")));
            RiddleReader rr = new RiddleReader(br);
            int num = (int) (Math.random()*5);
            if (num == 5)
                num = 4;
            q = rr.getRiddle(num).getQuestion();
            ans = rr.getRiddle(num).getAns();
            confirm_button.setOnClickListener(this);
            exit_button.setOnClickListener(this);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }


    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.confirm_button:
                if(textbox.getText() != null)
                    ansBox.setText(ans);
            case R.id.exit_button:
                finish();

        }



    }
}
