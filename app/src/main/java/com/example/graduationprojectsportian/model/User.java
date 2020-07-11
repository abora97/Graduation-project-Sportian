package com.example.graduationprojectsportian.model;

public class User {

    public String sport;
    public double Userlatitude;
    public double Userlongitude;
    public int distance;

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public double getUserlatitude() {
        return Userlatitude;
    }

    public void setUserlatitude(double userlatitude) {
        Userlatitude = userlatitude;
    }

    public double getUserlongitude() {
        return Userlongitude;
    }

    public void setUserlongitude(double userlongitude) {
        Userlongitude = userlongitude;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
