package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Contract {

    public void contract() {

    }

    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;
//todo
    public Contract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getvehicle() {
        return vehicle;
    }

    public void setvehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    //    ales Tax Amount (5%)
//• Recording Fee ($100)
//• Processing fee ($295 for vehicles under $10,000 and $495 for all other
    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();

    //SALE|20210928|Dana Wyatt|dana@texas.com|10112|1993|
    //Ford|Explorer|SUV|Red|525123|995.00|
    //49.75|100.00|295.00|1439.75|NO|0.0

}
