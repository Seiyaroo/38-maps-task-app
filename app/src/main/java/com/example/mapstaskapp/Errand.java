package com.example.mapstaskapp;

import com.google.android.gms.maps.model.LatLng;

public class Errand {
    String description;
    LatLng start;
    LatLng end;

    public Errand() {}

    public String errand(String description, LatLng start, LatLng end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public static Errand fromSnapshot(DataSnapshot snapshot) {
        Errand errand = new Errand();
        errand.description = snapshot.child("description").getValue(String.class);

        float startlat = snapshot.child("start").child("lat").getValue(float.class);
        float startlong = snapshot.child("start").child("long").getValue(float.class);
        errand.start = new LatLng(startlat, startlong);

        float endlat = snapshot.child("end").child("lat").getValue(float.class);
        float endlong = snapshot.child("end").child("long").getValue(float.class);
        errand.start = new LatLng(endlat, endlong);

        return errand;
    }
}
