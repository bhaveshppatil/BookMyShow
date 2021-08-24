package com.example.bookmyshow.Home.Buzz;

public class BuzzModel {
    private int buzzImageId;
    private String buzzTitle;
    private String buzzTime;

    public BuzzModel(int bImageId, String bTitle, String bTime) {
        this.buzzImageId = bImageId;
        this.buzzTitle = bTitle;
        this.buzzTime = bTime;
    }

    public int getBuzzImageId() {
        return buzzImageId;
    }

    public String getBuzzTitle() {
        return buzzTitle;
    }

    public String getBuzzTime() {
        return buzzTime;
    }

}