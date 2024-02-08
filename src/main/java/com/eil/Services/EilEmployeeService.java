package com.eil.Services;

import com.eil.Entities.EilEmployee;

import java.util.List;

public interface EilEmployeeService {
    List<EilEmployee> getAllEmployees();

    EilEmployee getEmployeeById(Long employeeId);

    List<EilEmployee> getEmployeesByDepartment(Long departmentId);

    EilEmployee login(String username, String password);
}

