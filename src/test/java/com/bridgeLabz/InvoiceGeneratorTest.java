package com.bridgeLabz;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple InvoiceGenerator.
 */
public class InvoiceGeneratorTest{

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance=2.0;
        int time=5;
        double fare = invoiceGenerator.totalFare(distance, time );
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnMinFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance=0.1;
        int time=1;
        double fare = invoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(5,fare,0.0);
    }
}
