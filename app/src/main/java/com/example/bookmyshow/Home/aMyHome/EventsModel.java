package com.example.bookmyshow.Home.aMyHome;

//import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class EventsModel implements Serializable {

    @SerializedName("Images")
    private String images;

    @SerializedName("EventName")
    private String eventName;

    @SerializedName("EventType")
    private String eventType;

    @SerializedName("WhereToWatch")
    private String whereToWatch;

    @SerializedName("Price")
    private String price;

    public String getImages() {
        return images;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getWhereToWatch() {
        return whereToWatch;
    }

    public String getPrice() {
        return price;
    }

}