package com.example.graduationprojectsportian.model;

public class Sport {
    public String center;
    public String sport;
    public String age;
    public String captain ;
    public String cost ;
    public String day;
    public String gender;
    public String time;
    public String phone;
    public double latitude;
    public double longitude;

    public Sport() {
    }

    public Sport(String center, String sport, String age, String captain, String cost, String day, String gender, String time, String phone, double latitude, double longitude) {
        this.center = center;
        this.sport = sport;
        this.age = age;
        this.captain = captain;
        this.cost = cost;
        this.day = day;
        this.gender = gender;
        this.time = time;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
