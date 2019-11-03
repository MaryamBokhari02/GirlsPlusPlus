package com.example.girls;

import android.location.Location;

public class Meeting {
    private int id;
    private Location location;
    private String date, title, description, address;

    public int getId(){
        return id;
    }
    public void setId (int id){
        this.id = id;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public Location getLocation() {
        return location;
    }

    public Meeting (int mId, String mDate, String mTitle, String mDescription, String mAddress, Location mLocation){
        date = mDate;
        id = mId;
        title = mTitle;
        description = mDescription;
        address = mAddress;
        location = mLocation;
    }

    public Meeting (String mDate, String mTitle, String mDescription, String mAddress){
        date = mDate;
        title = mTitle;
        description = mDescription;
        address = mAddress;
    }

}
