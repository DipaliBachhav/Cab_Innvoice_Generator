package com.InnvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Rides>> userRides = null ;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Rides[] rides) {
        ArrayList<Rides> rideArrayList = this.userRides.get(userId);
        if (rideArrayList == null){
            this.userRides.put(userId,new ArrayList<>(Arrays.asList(rides)));
        }
    }

    public Rides[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Rides[0]);
    }

}
