package com.example.girls;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FutureMeetingFragment extends Fragment {

    public interface OnMeetingSelectedListener {
        void onMeetingSelected(int meeting);
    }

    // Reference to the activity
    private OnMeetingSelectedListener mListener;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_future_meeting, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.meeting_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Send bands to recycler view
//        SongAdapter adapter = new SongAdapter(MusicDatabase.getInstance(getContext()).getSongs());
//        recyclerView.setAdapter(adapter);

        return view;
    }

    private class MeetingHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Meeting mMeeting;

        private TextView mNameTextView;

        public MeetingHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_meeting, parent, false));
            itemView.setOnClickListener(this);
            mNameTextView = itemView.findViewById(R.id.meetingName);
        }

        public void bind(Meeting meeting) {
            mMeeting = meeting;
            mNameTextView.setText(mMeeting.getTitle());
        }

        @Override
        public void onClick(View view) {
            // Tell ListActivity what song was clicked
            mListener.onMeetingSelected(mMeeting.getId());
        }
    }

    private class MeetingAdapter extends RecyclerView.Adapter<MeetingHolder> {

        private List<Meeting> mMeetings;

        public MeetingAdapter(List<Meeting> meetings) {
            mMeetings = meetings;
        }

        @Override
        public MeetingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new MeetingHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(MeetingHolder holder, int position) {
            Meeting meeting = mMeetings.get(position);
            holder.bind(meeting);
        }

        @Override
        public int getItemCount() {
            return mMeetings.size();
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMeetingSelectedListener) {
            mListener = (OnMeetingSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMeetingSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Notify activity of band selection
            String meetingId = (String) view.getTag();
            mListener.onMeetingSelected(Integer.parseInt(meetingId));
        }
    };
}