package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {

    private BigDecimal salesTaxAmount;
    private final BigDecimal recordingFee;
    private BigDecimal processingFee;
    private boolean finance;
    private Vehicle vehicle;

    // Constructor
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        this.vehicle = vehicle;
        this.recordingFee = new BigDecimal(100);

        // Processing fee based on vehicle price
        if (vehicle.getPrice() < 10000) {
            this.processingFee = new BigDecimal(295);
        } else {
            this.processingFee = new BigDecimal(495);
        }

        // Sales tax = 5% of vehicle price
        BigDecimal priceBD = BigDecimal.valueOf(vehicle.getPrice());
        this.salesTaxAmount = priceBD.multiply(new BigDecimal(0.05
        )).setScale(2, RoundingMode.HALF_UP);
    }

    // Getters and setters
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public BigDecimal getRecordingFee() {
        return recordingFee;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    // Calculate total price = price + sales tax + recording fee + processing fee
    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal priceBD = BigDecimal.valueOf(vehicle.getPrice());
        BigDecimal total = priceBD.add(salesTaxAmount).add(recordingFee).add(processingFee);
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    // Calculate monthly payment based on financing option
    @Override
    public BigDecimal getMonthlyPayment() {
        if (!finance) {
            // No financing, so monthly payment is zero
            return BigDecimal.ZERO.setScale(2);
        }

        BigDecimal priceBD = BigDecimal.valueOf(vehicle.getPrice());
        BigDecimal annualInterestRate;
        int months;

        if (priceBD.compareTo(new BigDecimal("10000")) >= 0) {
            annualInterestRate = new BigDecimal("0.0425"); // 4.25% interest
            months = 48;
        } else {
            annualInterestRate = new BigDecimal("0.0525"); // 5.25% interest
            months = 24;
        }

        // Simple interest calculation:
        // total loan = principal + interest
        // interest = principal * rate * years
        // monthly payment = total loan / months

        BigDecimal years = new BigDecimal(months).divide(new BigDecimal("12"), 4, RoundingMode.HALF_UP);
        BigDecimal interest = priceBD.multiply(annualInterestRate).multiply(years);
        BigDecimal totalLoan = priceBD.add(interest);
        BigDecimal monthlyPayment = totalLoan.divide(new BigDecimal(months), 2, RoundingMode.HALF_UP);

        return monthlyPayment;
    }
}
