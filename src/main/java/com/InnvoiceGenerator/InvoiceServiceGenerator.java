package com.InnvoiceGenerator;

public class InvoiceServiceGenerator {
    public RideRepository rideRepository;

    public InvoiceServiceGenerator() {
        this.rideRepository = new RideRepository();

    }
    public enum RideCategories{
        NORMAL_RIDE,PREMIUM_RIDE;
    }
    public  RideCategories rideCategories;

    public InvoiceServiceGenerator(RideCategories premiumRide) {
        this.rideCategories = premiumRide;
    }

    public InvoiceServiceGenerator(RideRepository rideRepository) {
        this.rideRepository=new RideRepository();
        this.rideRepository = rideRepository;
    }


    public double calculateFare(double distance, int time) {
        double totalFare = CabInvoiceFactory.givenRideType(distance,time,rideCategories);
        return totalFare;
    }

    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Rides[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
    public InvoiceSummary getInvoiceSummary(String userId, RideCategories premiumRide) {
        this.rideCategories = premiumRide;
        return this.calculateFare(rideRepository.getRides(userId));
    }
}

