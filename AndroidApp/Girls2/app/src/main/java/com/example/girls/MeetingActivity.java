package com.example.girls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MeetingActivity extends AppCompatActivity {
    public static String EXTRA_MEETING_ID = "meetingId";

    Button delete, feedback, checkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.meeting_fragment_container);

        if (fragment == null) {
            fragment = new MeetingFragment();
            int songId = getIntent().getIntExtra(EXTRA_MEETING_ID, 1);
            fragment = MeetingFragment.newInstance(songId);
            fragmentManager.beginTransaction()
                    .add(R.id.meeting_fragment_container, fragment)
                    .commit();
        }

        feedback = findViewById(R.id.feed_back);
        feedback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openFeedbackScreen();
            }
        });

        checkin = findViewById(R.id.check_in);
        checkin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openCheckinScreen();
            }
        });
    }
    private void openFeedbackScreen(){
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }

    private void openCheckinScreen(){
        //todo send that they checkedin to the database
        Toast.makeText(getApplicationContext(), "You successfully checked in!!", Toast.LENGTH_SHORT).show();
    }
}