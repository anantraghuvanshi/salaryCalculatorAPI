package com.SalaryCalculatorAPI.model;

public class SalaryResponse {
    private double monthlyInhandSalary;
    private double annualTax;

    public double getMonthlyInhandSalary() {
        return monthlyInhandSalary;
    }

    public void setMonthlyInhandSalary(double monthlyInhandSalary) {
        this.monthlyInhandSalary = monthlyInhandSalary;
    }

    public double getAnnualTax() {
        return annualTax;
    }

    public void setAnnualTax(double annualTax) {
        this.annualTax = annualTax;
    }
}
