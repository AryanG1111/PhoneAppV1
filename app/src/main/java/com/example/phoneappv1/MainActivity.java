package com.example.phoneappv1;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    RadioGroup activity;
    Button confirm_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        activity = findViewById(R.id.ActivityGroup);
        confirm_button = findViewById(R.id.confirm_button);
        confirm_button.setOnClickListener(this);

    }

    private void newActivity(String a) {
        try {

            Bundle b = new Bundle();
            Intent intent;


            switch(a) {
                case ("Brain Training"):
                    intent = new Intent(this, BrainTraining.class);
                    startActivity(intent);
                    Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
                    break;
                case ("Riddles"):
                    intent = new Intent(this, Riddles.class);
                    startActivity(intent);
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void onClick(View view) {
        String sub = ((RadioButton) findViewById(activity.getCheckedRadioButtonId())).getText().toString();
        newActivity(sub);

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}