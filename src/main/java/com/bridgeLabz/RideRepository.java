package com.bridgeLabz;

import java.util.HashMap;

public class RideRepository {

    public static HashMap<Integer, Ride[]> RIDE_REPOSITORY = null;
    public static Integer USER_ID =0;

    public RideRepository(HashMap<Integer, Ride[]> RIDE_REPOSITORY, Integer USER_ID){
        this.RIDE_REPOSITORY = RIDE_REPOSITORY;
        this.USER_ID = USER_ID;

    }
    public InvoiceSummary calculateFare(){
        if(this.USER_ID == null || this.RIDE_REPOSITORY.get(USER_ID) == null){
            throw  new NullPointerException("Null value is not allowed");
        }
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] userRideDetails = this.RIDE_REPOSITORY.get(USER_ID);
        double totalFare = 0;
        for (Ride ride : userRideDetails){
            totalFare += invoiceGenerator.calculateFare(ride.distance,ride.time);
        }
        return  new InvoiceSummary(userRideDetails.length, totalFare);
    }
}
