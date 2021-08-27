package com.example.bookmyshow.Home.aMyHome;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//import javax.annotation.Generated;

//@Generated("com.robohorse.robopojogenerator")
public class ResponseModel implements Serializable {

	@SerializedName("Events")
	private List<EventsModel> events;

	public List<EventsModel> getEvents(){
		return events;
	}
}