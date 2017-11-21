package com.example.dell.learnaboutromania;

import android.util.EventLogTags;

import com.example.dell.learnaboutromania.model.City;
import com.example.dell.learnaboutromania.model.Coordinates;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kinga on 11/21/2017.
 */

public class PlacesDatabaseManager {
    private static FirebaseDatabase database;
    private static DatabaseReference citiesReference;
    private static List<City> places;
    private static Map<Object, Object> rawPlaces;

    public static void populatePlaces() {
        database = FirebaseDatabase.getInstance();
        citiesReference = database.getReference("Cities");

        citiesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rawPlaces = (Map<Object, Object>) dataSnapshot.getValue();
                places = convertCities(rawPlaces);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private static List<City> convertCities(Map<Object, Object> rawPlaces) {
        List<City> cities = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : rawPlaces.entrySet()) {
            City city = convertCity(entry);
            cities.add(city);


        }
        return cities;
    }

    public static City getCityByName(String name){
        for (City city : places) {
            if( city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }

    private static City convertCity(Map.Entry<Object, Object> entry) {
        City city = new City();
        city.setName((String) entry.getKey());
        Map<Object, Object> cityDetails = (Map<Object, Object>) entry.getValue();
        city.setDescription((String) cityDetails.get("Description"));
        Map<Object, Object> rawCoordinates = (Map<Object, Object>) cityDetails.get("Coordinates");
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude((Double) rawCoordinates.get("Latitude"));
        coordinates.setLongitude((Double) rawCoordinates.get("Long"));
        city.setCoordinates(coordinates);

        return city;
    }
//    public static HashMap<Object, Object> getPlaces() {
//        return rawPlaces;
//    }
}