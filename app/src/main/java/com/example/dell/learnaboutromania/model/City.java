package com.example.dell.learnaboutromania.model;

/**
 * Created by kinga on 11/21/2017.
 */

public class City {
    private Coordinates coordinates;
    private String description;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.example.dell.learnaboutromania.model.Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(com.example.dell.learnaboutromania.model.Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
