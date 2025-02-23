package com.example.phoneappv1;

import android.content.Intent;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import androidx.appcompat.app.AppCompatActivity;

public class BrainTraining extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    RadioGroup subject;
    CheckBox feedback;
    TextView numQtxt;
    RatingBar diffRat;
    SeekBar numQbar, diffBar;
    Button confirm_button;
    Button exit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_menu);
        subject = findViewById(R.id.subjectGroup);
        feedback = findViewById(R.id.boxFeedback);
        numQtxt = findViewById(R.id.txtNumQ);
        diffRat = findViewById(R.id.ratingBar);
        numQbar = findViewById(R.id.numQBar);
        diffBar = findViewById(R.id.diffBar);
        confirm_button = findViewById(R.id.confirm_button);
        exit_button = findViewById(R.id.exit_button);

        numQbar.setOnSeekBarChangeListener(this);
        diffBar.setOnSeekBarChangeListener(this);
        confirm_button.setOnClickListener(this);
        exit_button.setOnClickListener(this);

    }

    private void newQuestionSequence(String filename, int numQ, int diff, boolean feedback) {
        try {
            Intent intent = new Intent(this, QuestionSequence.class);
            Bundle b = new Bundle();
            System.out.println("hi");

            BufferedReader br = new BufferedReader(new InputStreamReader(this.getAssets().open(filename + ".txt")));

            QuestionReader subQues = new QuestionReader(br);

            b.putSerializable("QuestionReader", subQues);
            b.putInt("total", numQ);
            b.putInt("diff", diff);
            b.putBoolean("feedback", feedback);
            b.putString("subject", filename);

            intent.putExtras(b);

            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirm_button:
                int numQ = numQbar.getProgress() * 5 + 5;
                int diff = diffBar.getProgress() + 1;
                boolean fb = feedback.isChecked();
                String sub = ((RadioButton) findViewById(subject.getCheckedRadioButtonId())).getText().toString();
                newQuestionSequence(sub, numQ, diff, fb);
                break;
            case R.id.exit_button:
                finish();
                break;
        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int numQ = numQbar.getProgress() * 5 + 5;
        int diff = diffBar.getProgress() + 1;
        switch (seekBar.getId()) {
            case R.id.numQBar:
                numQtxt.setText("Number of Questions: " + numQ);
                break;
            case R.id.diffBar:
                diffRat.setRating((float) diff);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
