package com.InnvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class InnvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceServiceGenerator invoiceServiceGenerator = new InvoiceServiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceServiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        InvoiceServiceGenerator invoiceServiceGenerator = new InvoiceServiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceServiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }
}
