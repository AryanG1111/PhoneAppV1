package com.example.phoneappv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Schedule extends AppCompatActivity implements View.OnClickListener{

    RadioGroup day;
    Button confirm_button;
    Button exit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_screen);
        day = findViewById(R.id.DayGroup);
        confirm_button = findViewById(R.id.confirm_button);
        exit_button = findViewById(R.id.exit_button);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirm_button:
                Bundle b = new Bundle();
                String sub = ((RadioButton) findViewById(day.getCheckedRadioButtonId())).getText().toString();
                b.putString("day", sub);
                Intent intent = new Intent(this, ScheduleDay.class);
                intent.putExtras(b);
                startActivity(intent);
            case R.id.exit_button:
                finish();
                break;
        }

    }

}
