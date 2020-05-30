package com.InnvoiceGenerator;

public class CabInvoiceFactory {
    public static double givenRideType(double distance, int time, InvoiceServiceGenerator.RideCategories rideCategories){
        RideCategory rideCategory = new RideCategory();
        if (rideCategories == null || rideCategories.equals(InvoiceServiceGenerator.RideCategories.NORMAL_RIDE))
            return rideCategory.normalRide(distance,time);
        else if (rideCategories.equals(InvoiceServiceGenerator.RideCategories.PREMIUM_RIDE))
            return rideCategory.premiumRide(distance,time);
        else
            return 0;
    }
}
