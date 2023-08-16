package com.SalaryCalculatorAPI.controller;

import com.SalaryCalculatorAPI.model.SalaryRequest;
import com.SalaryCalculatorAPI.model.SalaryResponse;
import com.SalaryCalculatorAPI.service.SalaryCalculatorService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salary")
public class SalaryCalculatorController {

    @Autowired
    private SalaryCalculatorService salaryCalculatorService;
    @ApiOperation(value = "Calculate the salary based on provided parameters")
    @PostMapping("/calculate")
    public ResponseEntity<SalaryResponse> calculate(@Valid @RequestBody SalaryRequest request) {
        return ResponseEntity.ok(salaryCalculatorService.calculateSalary(request));
    }
}
