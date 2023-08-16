package com.SalaryCalculatorAPI.model;

import jakarta.validation.constraints.*;


public class SalaryRequest {
    @PositiveOrZero(message = "Base pay can not be negative")
    private double basePay;

    @PositiveOrZero(message = "Provident fund cannot be negative.")
    @DecimalMax(value = "0.8", message = "Provident fund cannot be greater than 80% of base pay.")
    private double providentFund;

    @Pattern(regexp = "^(old|new)$", message = "Tax regime must be 'old' or 'new'.")
    private String taxRegime;

    public double getBasePay() {
        return basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    public double getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(double providentFund) {
        this.providentFund = providentFund;
    }

    public String getTaxRegime() {
        return taxRegime;
    }

    public void setTaxRegime(String taxRegime) {
        this.taxRegime = taxRegime;
    }
}
