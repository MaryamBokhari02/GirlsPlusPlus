package com.example.girls;

public class Attendance {
    private int tableId, profileId, meetingId;
    private String ipAddress, loginTime, feedback;
    private float latitude, longitude;

    public Attendance(int profileId, int meetingId, String ipAddress, String loginTime, String feedback, float latitude, float longitude) {
        this.profileId = profileId;
        this.meetingId = meetingId;
        this.ipAddress = ipAddress;
        this.loginTime = loginTime;
        this.feedback = feedback;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Attendance(int profileId, int meetingId, String ipAddress, String loginTime, float latitude, float longitude) {
        this.profileId = profileId;
        this.meetingId = meetingId;
        this.ipAddress = ipAddress;
        this.loginTime = loginTime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
