package com.bridgeLabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Unit test for simple InvoiceGenerator.
 */
public class InvoiceGeneratorTest{
    InvoiceGenerator invoiceGenerator;
    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance=2.0;
        int time=5;
        double fare = invoiceGenerator.calculateFare(distance, time );
        Assert.assertEquals(25,fare,0.0);
    }
    @Test
    public void givenDistanceAndTime_shouldReturnMinFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance=0.1;
        int time=1;
        double fare = invoiceGenerator.calculateFare(distance, time );
        Assert.assertEquals(5,fare,0.0);
    }
    @Test
    public void givenDistanceAndTime_shouldReturnInvoiceSummary(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedSummary,invoiceSummary);
    }
    @Test
    public void givenDistanceAndTime_shouldReturnInvoice(){
        HashMap<Integer,Ride[]> rideRepo = new HashMap<>();
        Ride[] rides1 ={new Ride(2.0,5),new Ride(0.1,1)};
        Ride[] rides2 ={new Ride(10.0,2),new Ride(5.0,1)};
        Ride[] rides3 ={new Ride(7.0,3),new Ride(5.0,1)};
        Ride[] rides4 ={new Ride(4.0,3),new Ride(5.0,4)};
        rideRepo.put(1,rides1);
        rideRepo.put(2,rides2);
        rideRepo.put(3,rides3);
        rideRepo.put(4,rides4);
        int userID = 1;
        RideRepository rideRepository = new RideRepository(rideRepo,userID);
        InvoiceSummary invoiceSummary = rideRepository.calculateFare();
        InvoiceSummary expectedSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedSummary, invoiceSummary);

    }
}
