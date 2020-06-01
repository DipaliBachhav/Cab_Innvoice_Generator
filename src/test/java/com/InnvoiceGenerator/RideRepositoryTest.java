package com.InnvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class RideRepositoryTest {

    @Test
    public void givenUserId_whenFound_shouldReturnRideList(){
        RideRepository rideRepository = new RideRepository();
        Rides[] rides = {new Rides(2.0, 5),
                new Rides(0.1, 1)};
        rideRepository.addRides("cab@invoice",rides);
        Assert.assertEquals(rideRepository.getRides("cab@invoice").length,rides.length);
    }

}
