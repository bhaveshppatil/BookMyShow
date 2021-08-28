package com.example.bookmyshow.Home.aMyHome.MovieRecycler;

public class MoviesModel {
    private String movieTitle, languages;
    private int thumbID;

    public MoviesModel(String movieTitle, String languages, int thumbID) {
        this.movieTitle = movieTitle;
        this.thumbID = thumbID;
        this.languages = languages;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getThumbID() {
        return thumbID;
    }

    public void setThumbID(int thumbID) {
        this.thumbID = thumbID;
    }

}