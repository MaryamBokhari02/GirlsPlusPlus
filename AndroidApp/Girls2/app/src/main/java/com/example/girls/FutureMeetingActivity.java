package com.example.girls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FutureMeetingActivity extends AppCompatActivity implements
        FutureMeetingFragment.OnMeetingSelectedListener{

    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_meeting);


        add = findViewById(R.id.Add);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openAddScreen();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.meeting_fragment_container);

        if (fragment == null) {
            fragment = new FutureMeetingFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.meeting_fragment_container, fragment)
                    .commit();
        }


    }


    @Override
    public void onMeetingSelected(int meetingId){
        Intent intent = new Intent(this, MeetingActivity.class);
        intent.putExtra(MeetingActivity.EXTRA_MEETING_ID, meetingId);
        startActivity(intent);

    }

    private void openAddScreen(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }


}