package com.example.dell.learnaboutromania.model;

import java.io.Serializable;

/**
 * Created by kinga on 11/21/2017.
 */

public class Coordinates implements Serializable {
    private Double latitude;
    private  Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
