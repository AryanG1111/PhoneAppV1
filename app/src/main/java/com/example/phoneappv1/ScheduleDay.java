package com.example.phoneappv1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class ScheduleDay extends AppCompatActivity implements View.OnClickListener {

    Button exit_button;
    Button add_button;
    TextInputEditText textbox;
    TextView textAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monday_screen);
        exit_button = findViewById(R.id.exit_button);
        add_button = findViewById(R.id.add_button);
        textbox = findViewById(R.id.textBox);
        textAdd = findViewById(R.id.call);
        add_button.setOnClickListener(this);
        exit_button.setOnClickListener(this);
    }

    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.add_button:
                if(textbox.getText() != null)
                    textAdd.setText(textbox.getText());
                    textbox.setText("");
                break;
            case R.id.exit_button:
                finish();
                break;
        }
    }



}
