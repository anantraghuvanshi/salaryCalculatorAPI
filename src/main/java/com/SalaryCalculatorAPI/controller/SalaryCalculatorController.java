package com.SalaryCalculatorAPI.controller;

import com.SalaryCalculatorAPI.service.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salary")
public class SalaryCalculatorController {

    @Autowired
    private SalaryCalculatorService salaryCalculatorService;
}
