package com.example.dell.learnaboutromania;

import android.widget.ListView;

import com.example.dell.learnaboutromania.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * Created by Dell on 11/14/2017.
 */

public class DatabaseManager {
    private static FirebaseDatabase database;
    private static DatabaseReference databaseref;
    private static DatabaseReference databaseref2;
    private static DatabaseReference databaseref3;
    private static DatabaseReference databaseref4;
    private static DatabaseReference databaseref5;
    private static HashMap<Object, Object> foods;
    private static HashMap<Object, Object> people;
    private static HashMap<Object, Object> clothes;
    private static HashMap<Object, Object> objects;
    private static HashMap<Object, Object> slang;

    public static void populatefoods() {
        database = FirebaseDatabase.getInstance();
        databaseref = database.getReference("Food");

        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                foods = (HashMap<Object, Object>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public static void populatepeople() {
        database = FirebaseDatabase.getInstance();
        databaseref2 = database.getReference("People");

        databaseref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                people = (HashMap<Object, Object>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public static void populateclothes() {
        database = FirebaseDatabase.getInstance();
        databaseref3 = database.getReference("Clothes");

        databaseref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                clothes = (HashMap<Object, Object>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public static void populateobjects() {
        database = FirebaseDatabase.getInstance();
        databaseref4 = database.getReference("Objects");

        databaseref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                objects = (HashMap<Object, Object>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public static void populateslang() {
        database = FirebaseDatabase.getInstance();
        databaseref5 = database.getReference("Slang");

        databaseref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                slang = (HashMap<Object, Object>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public static HashMap<Object, Object> getFoods() {
        return foods;
    }

    public static  HashMap<Object, Object> getPeople() {
        return people;
    }

    public static HashMap<Object, Object> getClothes() {
        return clothes;
    }

    public static HashMap<Object, Object> getObjects() {
        return objects;
    }

    public static HashMap<Object, Object> getSlang() {
        return slang;
    }
}
