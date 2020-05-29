package com.InnvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class InnvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceServiceGenerator invoiceService = new InvoiceServiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }
}
