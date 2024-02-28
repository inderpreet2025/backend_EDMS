package com.eil.Controller;

import com.eil.Services.EilEmployeeService;
import com.eil.Entities.EilEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EilEmployeeController {

    @Autowired
    private EilEmployeeService employeeService;

    @GetMapping
    public List<EilEmployee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Optional<EilEmployee> getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/department/{departmentId}")
    public List<EilEmployee> getEmployeesByDepartment(@PathVariable int departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }

    @PostMapping("/login")
    public EilEmployee login(@RequestBody LoginRequest loginRequest) {
        return employeeService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

}

