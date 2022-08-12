package com.bridgelabz.employeepayrollapps.service;

import com.bridgelabz.employeepayrollapps.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapps.entity.Employee;
import com.bridgelabz.employeepayrollapps.exception.UserNotFoundException;
import com.bridgelabz.employeepayrollapps.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    HashMap<Integer,Employee> employeeIntegerHashMap=new HashMap<>();
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employee) {
       employeeIntegerHashMap.put(employee.getId(), employee);
        System.out.println(employeeIntegerHashMap);
       return employee;

    }

    @Override
    public List<Employee> getEmployee() {
        return employeeIntegerHashMap.entrySet().stream().map(employee->employee.getValue()).toList();
    }
    public Employee getById(int id){
        return employeeIntegerHashMap.get(id);
    }

    @Override
    public Employee UpdateEmp(int id, EmployeeDto employee) {
        Employee employee1=employeeIntegerHashMap.get(id);
        employee1.UpdateEmployee(employee);
        return employee1;
    }

    @Override
    public Employee deleteEmp(int id) {
       return employeeIntegerHashMap.remove(id);

    }

    @Override
    public Employee createEmployees(Employee employee) {
        return employeeRepository.save(employee);
    }

    //WE HAVE USED DTO,EXCEPTION,SERVICE LAYER,ADVICE
    @Override
    public Employee addEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee(employeeDto);
        return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getEmployeeall(){

        return employeeRepository.findAll();
    }

    @Override
    public Employee getByid(int id) throws UserNotFoundException {
        Employee employee=employeeRepository.findById(id).orElse(null);
        if(employee!=null){
            return employee;
        }else{
            throw new UserNotFoundException("Employee of this id not found"+id);
        }
    }

    @Override
    public Employee editEmployee(int id,EmployeeDto employeeDto) throws UserNotFoundException {
        Employee employee=this.getByid(id);
        employee.UpdateEmployee(employeeDto);
        return employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "deleted successfully";

    }


}
