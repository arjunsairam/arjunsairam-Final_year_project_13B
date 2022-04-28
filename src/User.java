package com.example.criminal123456;

public class User {
    private String Location;
    private String Name;
    private  String date;
    private  String time;

    public User(String location, String name, String date, String time) {
        Location = location;
        Name = name;
        this.date = date;
        this.time = time;
    }

    public  User(){

    }
    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
