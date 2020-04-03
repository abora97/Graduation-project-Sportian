package com.example.graduationprojectsportian.model;

public class ScreenItem {
    String Titel, Description;
    int ScreenImg;

    public ScreenItem(String titel, String description, int screenImg) {
        Titel = titel;
        Description = description;
        ScreenImg = screenImg;
    }



    public void setDescription(String description) {
        Description = description;
    }

    public void setScreenItem(int screenItem) {
        ScreenImg = screenItem;
    }

    public String getTitel() {
        return Titel;
    }

    public String getDescription() {
        return Description;
    }

    public int getScreenItem() {
        return ScreenImg;
    }
}
