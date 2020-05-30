package com.InnvoiceGenerator;

public class RideCategory {
    private static final double NORMAL_RIDE_COST_PER_KILOMETER = 10;
    private static final int NORMAL_RIDE_COST_PER_TIME = 1;
    private static final int NORMAL_RIDE_MINIMUM_FARE = 5;
    private static final double PREMIUM_RIDE_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_RIDE_COST_PER_MINUTE = 2;
    private static final int PREMIUM_RIDE_MINIMUM_FARE = 20;

    public double normalRide(double distance, int time) {
        double totalFare = distance * NORMAL_RIDE_COST_PER_KILOMETER + time * NORMAL_RIDE_COST_PER_TIME;
        if (totalFare <= NORMAL_RIDE_MINIMUM_FARE)
            return NORMAL_RIDE_MINIMUM_FARE;
        return totalFare;
    }

    public double premiumRide(double distance, int time) {
        double totalFare = distance * PREMIUM_RIDE_COST_PER_KILOMETER + time * PREMIUM_RIDE_COST_PER_MINUTE;
        if (totalFare <= PREMIUM_RIDE_MINIMUM_FARE)
            return PREMIUM_RIDE_MINIMUM_FARE;
        return totalFare;
    }
}
