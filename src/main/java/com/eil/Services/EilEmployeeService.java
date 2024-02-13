package com.eil.Services;

import com.eil.Entities.EilEmployee;

import java.util.List;
import java.util.Optional;

public interface EilEmployeeService {
    List<EilEmployee> getAllEmployees();

     Optional<EilEmployee> getEmployeeById(Long employeeId);

    List<EilEmployee> getEmployeesByDepartment(int departmentId);

    EilEmployee login(String username, String password);
}

