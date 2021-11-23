package com.teamBookMyShow.bookmyshow.RegisterEvent;

import java.io.Serializable;

public class DataHelper implements Serializable {

    String name, email, contact, eventName, date, time, ticketQuantity, price, imageUrl;

    public DataHelper(String name, String email, String contact, String eventName, String date, String time, String ticketQuantity, String price, String imageUrl) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.ticketQuantity = ticketQuantity;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(String ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}