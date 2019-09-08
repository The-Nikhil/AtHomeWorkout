package com.nikhilkanyal.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnExercise,btnSetting,btnCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExercise=(Button)findViewById(R.id.exercises_button);
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ListExercises.class);
                startActivity(intent);
            }
        });
        btnSetting=(Button)findViewById(R.id.settings_button);
        //btnCalendar=(Button)findViewById(R.id.calendar_button);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.nikhilkanyal.remind");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }

            }
        });


    }
}
