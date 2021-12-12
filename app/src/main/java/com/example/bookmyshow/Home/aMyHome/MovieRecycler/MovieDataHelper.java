package com.example.bookmyshow.Home.aMyHome.MovieRecycler;

public class MovieDataHelper {

    private String movieThumbnailUrl, movieTitle, totalPrice, ticketQuantity, date;

    public MovieDataHelper(String movieThumbnailUrl, String movieTitle, String totalPrice, String ticketQuantity, String date) {
        this.movieThumbnailUrl = movieThumbnailUrl;
        this.movieTitle = movieTitle;
        this.totalPrice = totalPrice;
        this.ticketQuantity = ticketQuantity;
        this.date = date;
    }

    public String getMovieThumbnailUrl() {
        return movieThumbnailUrl;
    }

    public void setMovieThumbnailUrl(String movieThumbnailUrl) {
        this.movieThumbnailUrl = movieThumbnailUrl;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(String ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
