package com.example.girls;

import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.time.Month;

public class MeetingFragment extends Fragment {
    private GoogleMap mMap;
    private Location mLocation;
    double latitude, longitude;
    private String date, title, description, address;

    private Meeting mMeeting = new Meeting("2019-07-21 06:43AM", "Meet the team", "Come join us for a wonderful day filled with fun at the waterpark. We will be swimming with sharks. Please do not be eaten.", "The moon, Three turns past the left, Saturn");

    public static MeetingFragment newInstance(int meetingId) {
        MeetingFragment fragment = new MeetingFragment();
        Bundle args = new Bundle();
        args.putInt("meetingId", meetingId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Get the band ID from the intent that started DetailsActivity
        int meetingId = 1;
        if (getArguments() != null) {
            meetingId = getArguments().getInt("meetingId");
        }

//        mSong = MusicDatabase.getInstance(getContext()).getSong(songId);
//        mAlbum = MusicDatabase.getInstance(getContext()).getAlbum(mSong.getAlbum());
//        mArtist = MusicDatabase.getInstance(getContext()).getArtist(mAlbum.getArtist());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_meeting, container, false);

        TextView nameTextView = (TextView) view.findViewById(R.id.meeting_title);
        nameTextView.setText(mMeeting.getTitle());

        TextView descriptionTextView = (TextView) view.findViewById(R.id.meeting_description);
        descriptionTextView.setText(mMeeting.getDescription());

        TextView addressTextView = (TextView) view.findViewById(R.id.meeting_address);
        addressTextView.setText("Location: " + mMeeting.getAddress());

        String date = mMeeting.getDate();

        String[] arrOfStr = date.split(" ", 2);
        String[] arrOfStr2 = (arrOfStr[0]).split("-", 3);

        Resources res = getResources();
        String[] months = res.getStringArray(R.array.month_array);


        TextView dateTextView = (TextView) view.findViewById(R.id.meeting_date);
        dateTextView.setText("Date: " + months[Integer.parseInt(arrOfStr2[1])-1] + " " + arrOfStr2[2] + ", " + arrOfStr2[0]);

        TextView timeTextView = (TextView) view.findViewById(R.id.meeting_time);
        timeTextView.setText("Time: " + arrOfStr[1]);

        return view;
    }


    public MeetingFragment() {
        // Required empty public constructor
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        LatLng myLocation = new LatLng(latitude, longitude);
//        mMap.addMarker(new MarkerOptions().position(myLocation).title("Your Location"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
//    }
}
