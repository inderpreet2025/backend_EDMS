package com.eil.ServiceImpl;

import com.eil.Entities.EilEmployee;
import com.eil.Repositories.EilEmployeeRepository;
import com.eil.Services.EilEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EilEmployeeService {

    @Autowired
    private EilEmployeeRepository employeeRepository;

    @Override
    public List<EilEmployee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EilEmployee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public List<EilEmployee> getEmployeesByDepartment(int departmentId) {
        return employeeRepository.findByDepartment_DepartmentId(departmentId);
    }

    @Override
    public EilEmployee login(String username, String password) {
        return employeeRepository.findByFirstNameAndPassword(username, password).orElse(null);
    }
}

