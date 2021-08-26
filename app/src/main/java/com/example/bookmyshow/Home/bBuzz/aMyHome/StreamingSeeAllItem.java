package com.example.bookmyshow.Home.bBuzz.aMyHome;

public class StreamingSeeAllItem {
    private int eventImage;
    private String eventName;
    private String eventType;
    private String eventWhereToWatch;
    private String eventPrice;

    public StreamingSeeAllItem(int eventImage, String eventName, String eventType, String eventWhereToWatch, String eventPrice) {
        this.eventImage = eventImage;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventWhereToWatch = eventWhereToWatch;
        this.eventPrice = eventPrice;
    }

    public int getEventImage() {
        return eventImage;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventWhereToWatch() {
        return eventWhereToWatch;
    }

    public String getEventPrice() {
        return eventPrice;
    }
}
