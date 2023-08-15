package com.SalaryCalculatorAPI.service;

import com.SalaryCalculatorAPI.model.SalaryRequest;
import com.SalaryCalculatorAPI.model.SalaryResponse;
import org.springframework.stereotype.Service;

@Service
public class SalaryCalculatorService {
    public SalaryResponse calculateSalary(SalaryRequest request) {
        SalaryResponse response = new SalaryResponse();
        double tax = calculateTax(request);
        double monthlySalary = (request.getBasePay() - request.getProvidentFund() - tax) / 12;
        response.setMonthlyInhandSalary(monthlySalary);
        response.setAnnualTax(tax);
        return response;
    }
    private double calculateTax(SalaryRequest request) {
        double taxableSalary = request.getBasePay() - request.getProvidentFund();

        if ("old".equalsIgnoreCase(request.getTaxRegime())) {
            return calculateTaxOld(taxableSalary);
        } else {
            return calculateTaxNew(taxableSalary);
        }
    }
    private double calculateTaxOld(double taxableSalary) {
        double taxAmount = 0;
        double checkTaxableSalary = taxableSalary;

        if (checkTaxableSalary <= 550000) return 0;

        if (checkTaxableSalary > 1000000) {
            taxAmount += (checkTaxableSalary - 1000000) * 0.3;
            checkTaxableSalary = 1000000;
        }
        if (checkTaxableSalary > 500000) {
            taxAmount += (checkTaxableSalary - 500000) * 0.2;
            checkTaxableSalary = 500000;
        }
        if (checkTaxableSalary > 250000) {
            taxAmount += (checkTaxableSalary - 250000) * 0.05;
        }

        return taxAmount;
    }
    private double calculateTaxNew(double taxableSalary) {
        double taxAmount = 0;
        double checkTaxableSalary = taxableSalary;

        if (checkTaxableSalary <= 750000) return 0;

        if (checkTaxableSalary > 1500000) {
            taxAmount += (checkTaxableSalary - 1500000) * 0.3;
            checkTaxableSalary = 1500000;
        }
        if (checkTaxableSalary > 1200000) {
            taxAmount += (checkTaxableSalary - 1200000) * 0.2;
            checkTaxableSalary = 1200000;
        }
        if (checkTaxableSalary > 900000) {
            taxAmount += (checkTaxableSalary - 900000) * 0.15;
            checkTaxableSalary = 900000;
        }
        if (checkTaxableSalary > 600000) {
            taxAmount += (checkTaxableSalary - 600000) * 0.1;
            checkTaxableSalary = 600000;
        }
        if (checkTaxableSalary > 300000) {
            taxAmount += (checkTaxableSalary - 300000) * 0.05;
        }

        return taxAmount;
    }
}
