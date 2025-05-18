package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract {

    private BigDecimal endingValue;  // 50% of original price
    private BigDecimal leaseFee;     // 7% of original price

    // Constructor calculates endingValue and leaseFee based on vehicle price
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        BigDecimal price = BigDecimal.valueOf(vehicle.getPrice());
        this.endingValue = price.multiply(BigDecimal.valueOf(0.5));
        this.leaseFee = price.multiply(BigDecimal.valueOf(0.07));
    }

    // Getters (no setters for endingValue and leaseFee per book)
    public BigDecimal getEndingValue() {
        return endingValue.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getLeaseFee() {
        return leaseFee.setScale(2, RoundingMode.HALF_UP);
    }

    // Monthly payment calculation:
    // Lease financed at 4% annual interest, for 36 months
    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal price = BigDecimal.valueOf(getvehicle().getPrice());
        BigDecimal monthlyInterestRate = BigDecimal.valueOf(0.04).divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);
        BigDecimal months = BigDecimal.valueOf(36);

        // Depreciation Fee = (Price - Ending Value) / months
        BigDecimal depreciationFee = price.subtract(endingValue).divide(months, 10, RoundingMode.HALF_UP);

        // Finance Fee = (Price + Ending Value) * monthly interest rate
        BigDecimal financeFee = price.add(endingValue).multiply(monthlyInterestRate);

        // Monthly Lease Fee = leaseFee / months
        BigDecimal monthlyLeaseFee = leaseFee.divide(months, 10, RoundingMode.HALF_UP);

        // Total monthly payment = depreciationFee + financeFee + monthlyLeaseFee
        return depreciationFee.add(financeFee).add(monthlyLeaseFee).setScale(2, RoundingMode.HALF_UP);
    }

    // Total price = monthly payment * 36 months
    @Override
    public BigDecimal getTotalPrice() {
        return getMonthlyPayment().multiply(BigDecimal.valueOf(36)).setScale(2, RoundingMode.HALF_UP);
    }
}
