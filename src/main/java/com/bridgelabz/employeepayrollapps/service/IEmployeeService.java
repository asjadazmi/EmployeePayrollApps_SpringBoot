package com.bridgelabz.employeepayrollapps.service;

import com.bridgelabz.employeepayrollapps.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapps.entity.Employee;
import com.bridgelabz.employeepayrollapps.exception.UserNotFoundException;

import java.util.List;

public interface IEmployeeService {
    public Employee createEmployee(Employee employee);

    public List<Employee> getEmployee();
    public Employee getById(int id);

    public Employee UpdateEmp(int id,EmployeeDto employee);
    public Employee deleteEmp(int id);

    public Employee createEmployees(Employee employee);

    public Employee addEmployee(EmployeeDto employeeDto);
    public List<Employee> getEmployeeall();

    public Employee getByid(int id) throws UserNotFoundException;

    public Employee editEmployee(int id,EmployeeDto employeeDto) throws UserNotFoundException;

    public String deleteEmployee(int id) ;

}
