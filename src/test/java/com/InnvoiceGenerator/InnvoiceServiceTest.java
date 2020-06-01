package com.InnvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InnvoiceServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    public RideRepository rideRepository;
    CabInvoiceFactory cabInvoiceFactory;
    RideCategory rideCategory;

    @InjectMocks
    InvoiceServiceGenerator invoiceServiceGenerator;



  // InvoiceServiceGenerator invoiceServiceGenerator = new InvoiceServiceGenerator();
  // RideRepository rideRepository;

    @Before
    public void setUp()throws Exception{
        invoiceServiceGenerator =new InvoiceServiceGenerator();
        rideRepository = new RideRepository();

    }

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

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {
        InvoiceServiceGenerator invoiceServiceGenerator = new InvoiceServiceGenerator();
        Rides[] rides = {new Rides(2.0, 5),
                new Rides(0.1, 1)};
        InvoiceSummary summary = invoiceServiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
        InvoiceServiceGenerator invoiceServiceGenerator = new InvoiceServiceGenerator();
        String userId = "cab@invoice";
        Rides[] rides = {   new Rides(2.0, 5),
                            new Rides(0.1, 1)
                        };
        invoiceServiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceServiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(summary,expectedInvoiceSummary);
    }

    @Test
    public void givenCategories_WhenRideList_ShouldReturnInvoiceSummary() {
        InvoiceServiceGenerator invoiceServiceGenerator = new InvoiceServiceGenerator();
        String userId = "cab@invoice";
        Rides rides[] = {new Rides(2.0, 5),new Rides(0.1, 1)};
        Rides rides1[] = {new Rides(2.0, 5),new Rides(0.1, 1)};
        //invoiceServiceGenerator.addRides(userId,rides);
        when(rideRepository.getRides(ArgumentMatchers.any())).thenReturn(rides);
        InvoiceSummary summary = invoiceServiceGenerator.getInvoiceSummary(userId, InvoiceServiceGenerator.RideCategories.PREMIUM_RIDE);
        InvoiceSummary expectedSummary = new InvoiceSummary(2,60.0);
        Assert.assertEquals(summary,expectedSummary);
    }
}
