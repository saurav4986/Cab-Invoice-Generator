package com.bridgeLabz;

public class InvoiceGenerator
{
    static final double COST_PER_KM = 10;
    static final int COST_PER_MINUTE = 1;
    static final double MINIMUM_FARE = 5;

    public static void main(String[] args )
    {
        System.out.println( "Welcome to Cab-Invoice-Generator!" );

        //Step 1: Calculating total fare which returns the total fare
        double totalFare = totalFare(0, 4); // distance,time
        double totalFare2 = totalFare(10, 4); // distance,time
        System.out.println(totalFare);
        System.out.println(totalFare2);
    }

    public static double totalFare(double distance, int time) {
        double totalCostForDist = distance * COST_PER_KM;
        int totalCostForTime = time * COST_PER_MINUTE;
        double totalFare = totalCostForDist + totalCostForTime;
        // if the total cost is lower than the 5 INR then minimum fare would be 5 INR
        if (totalFare < MINIMUM_FARE) {
            totalFare = MINIMUM_FARE;
        }
        System.out.println("Total fare of the journey is: " + totalFare);
        return totalFare;
    }
}
