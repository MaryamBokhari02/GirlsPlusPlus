package com.example.girls;

public class Profile {
    private int tableId, gender, classification, memberType;
    private String major, email, lastName, firstName, source, password;

    @Override
    public String toString() {
        return "Profile{" +
                "memberType=" + memberType +
                ", major='" + major + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", source='" + source + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Profile (){}
    public Profile(String major, int gender, int classification, int memberType, String email, String lastName, String firstName, String source, String password) {
        this.major = major;
        this.gender = gender;
        this.classification = classification;
        this.memberType = memberType;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.source = source;
        this.password = password;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public int getMemberType() {
        return memberType;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
