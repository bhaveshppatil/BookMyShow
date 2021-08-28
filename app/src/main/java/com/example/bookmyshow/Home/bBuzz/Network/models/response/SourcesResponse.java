package com.example.bookmyshow.Home.bBuzz.Network.models.response;

import com.example.bookmyshow.Home.bBuzz.Network.models.Source;

import java.util.List;

public class SourcesResponse {

    private String status;
    private List<Source> sources;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

}