package com.example.girls;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private EditText mFeedback;
    private TrackingActivity trackingActivity;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mFeedback = (EditText) findViewById(R.id.username);
//        Location location = trackingActivity.getLocation();



        //todo return feedback to database

        confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openFutureMeetingScreen();
            }
        });
    }
    private void openFutureMeetingScreen(){
        Intent intent = new Intent(this, FutureMeetingActivity.class);
        startActivity(intent);
    }
}
