package com.eil.ServiceImpl;

import com.eil.Entities.EilEmployee;
import com.eil.Repositories.EilEmployeeRepository;
import com.eil.Services.EilEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EilEmployeeService {

    @Autowired
    private EilEmployeeRepository employeeRepository;

    @Override
    public List<EilEmployee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EilEmployee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public List<EilEmployee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartment_DepartmentID(departmentId);
    }

    @Override
    public EilEmployee login(String username, String password) {
        return employeeRepository.findByFirstNameAndPassword(username, password).orElse(null);
    }
}

