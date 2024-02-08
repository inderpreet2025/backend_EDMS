package com.eil.Repositories;

import com.eil.Entities.EilEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EilEmployeeRepository extends JpaRepository<EilEmployee, Long> {
    Optional<EilEmployee> findByFirstNameAndPassword(String username, String password);

    List<EilEmployee> findByDepartment_DepartmentID(Long departmentId);
}

