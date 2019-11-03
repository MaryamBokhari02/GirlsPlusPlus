package com.example.girls;

import android.location.Location;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {
    private EditText mFeedback;
    private TrackingActivity trackingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mFeedback = (EditText) findViewById(R.id.username);
        Location location = trackingActivity.getLocation();

        //todo return feedback to database

    }


}
