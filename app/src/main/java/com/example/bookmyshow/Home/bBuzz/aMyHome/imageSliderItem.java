package com.example.bookmyshow.Home.bBuzz.aMyHome;

public class imageSliderItem {
    private int images;
    private String movieName;
    private String movieDuration;
    private String movieLanguage;
    private String movieDescription;

    public imageSliderItem(int images, String movieName, String movieDuration, String movieLanguage, String movieDescription) {
        this.images = images;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.movieLanguage = movieLanguage;
        this.movieDescription = movieDescription;
    }

    public int getImages() {
        return images;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public String getMovieDescription() {
        return movieDescription;
    }
}
