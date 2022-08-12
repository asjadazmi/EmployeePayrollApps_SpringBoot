package com.bridgelabz.employeepayrollapps.repository;

import com.bridgelabz.employeepayrollapps.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
